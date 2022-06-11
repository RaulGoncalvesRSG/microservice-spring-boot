FROM openjdk:11
VOLUME /tmp
#Muda o nome do arquivo .jar para hr-payroll. Não informa a porta pq será aleatória
ADD ./target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]