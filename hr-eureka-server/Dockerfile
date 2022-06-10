FROM openjdk:11
VOLUME /tmp
#Porta do Eureka
EXPOSE 8761
#Muda o nome do arquivo .jar para hr-eureka-server
ADD ./target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]