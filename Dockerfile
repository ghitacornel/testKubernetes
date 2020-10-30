FROM openjdk:latest
#RUN addgroup -S spring && adduser -S spring -G spring
#USER spring:spring
COPY /PersonRegister/target/PersonRegister-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]