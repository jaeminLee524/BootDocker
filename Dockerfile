FROM openjdk:11
ENV APP_HOME=/user/app
WORKDIR $APP_HOME
COPY build/libs/*.jar application.jar
EXPOSE 8888

CMD ["java", "-jar", "application.jar"]
