FROM bellsoft/liberica-openjdk-alpine:17.0.3.1-2
RUN apk add curl stoken
WORKDIR /
VOLUME /tmp
ADD ./target/service.jar service.jar
EXPOSE 8080 16000
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "service.jar"]
