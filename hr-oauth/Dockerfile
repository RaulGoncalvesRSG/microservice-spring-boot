FROM openjdk:11
VOLUME /tmp
#Muda o nome do arquivo .jar para hr-oauth. Não informa a porta pq será aleatória
ADD ./target/hr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT ["java","-jar","/hr-oauth.jar"]