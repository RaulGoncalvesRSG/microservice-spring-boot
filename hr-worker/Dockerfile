FROM openjdk:11
VOLUME /tmp
#Muda o nome do arquivo .jar para hr-worker. Não informa a porta pq será aleatória
ADD ./target/hr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT ["java","-jar","/hr-worker.jar"]