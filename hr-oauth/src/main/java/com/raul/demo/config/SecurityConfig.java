package com.raul.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
/*Classe para configurar a autenticação. É qnd a aplicação recebe as credenciais do usuário e vai
chamar o usuário pelo username do BD do microsserviço de user,
comparar a senha e ver se é igual. Se for, autentica o usuário e 
devolve o token */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired		//Faz o hash da senha para comparar
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired		//Busca usuário pelo username
	private UserDetailsService userDetailsService;

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	@Bean	//@Bean para injetar este método em outro componente. Se encontra em AuthorizationServerConfig
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}