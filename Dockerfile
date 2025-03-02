FROM  openjdk:latest
ADD target/QuizServiceApp.jar /QuizServiceApp.jar
EXPOSE 8080
ENTRYPOINT ("java" "-jar" "/QuizServiceApp.jar")