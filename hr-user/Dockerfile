FROM openjdk:11
VOLUME /tmp
#Muda o nome do arquivo .jar para hr-user. Não informa a porta pq será aleatória
ADD ./target/hr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT ["java","-jar","/hr-user.jar"]