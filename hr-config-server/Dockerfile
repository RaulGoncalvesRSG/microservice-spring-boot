FROM openjdk:11
VOLUME /tmp
#Porta do servidor de configuração
EXPOSE 8888
#Muda o nome do arquivo .jar para hr-config-server
ADD ./target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]