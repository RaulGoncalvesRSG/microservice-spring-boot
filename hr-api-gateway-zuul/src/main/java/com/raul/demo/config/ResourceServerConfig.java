package com.raul.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer	//Configura o projeto para ser um ResourceServer por meio desta classe
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };		//Rotas públicas
	private static final String[] OPERATOR = { "/hr-worker/**" };			//Rotas q são autorizados para operador
	//Rotas que apenad ADMIN podem acessar
	private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override		//Configura as autorizações
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//Todos caminhos públicos podem ser acessados mesmo q n esteja logado, pois são endpoints públicos
		.antMatchers(PUBLIC).permitAll()
		//Autoriza requisições GET para as rotas q estão no vetor OPERATOR. hasAnyRole indica as Roles de acesso
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		//Apenas o perfil ADMIN acessa as rotas q estão no vetor ADMIN
		.antMatchers(ADMIN).hasRole("ADMIN")
		//Qualquer rota q n esteja especificada anteriormente será acessa apenas se o usuário estiver autenticado
		.anyRequest().authenticated();
		
		http.cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));		//Quais origens poderão acessar o sistema
		//Métodos HTTP permitidos
		corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
		corsConfig.setAllowCredentials(true);			//Permite credenciais
		//Quais cabeçalhos serão permitidos
		corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		//Todos caminhos terão as configurações criadas
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);		//HIGHEST_PRECEDENCE é a precedência mais alta de ordem
		return bean;
	}
}