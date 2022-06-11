FROM openjdk:11
VOLUME /tmp
#Porta da API Gateway Zuul
EXPOSE 8765
#Muda o nome do arquivo .jar para hr-api-gateway-zuul
ADD ./target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]