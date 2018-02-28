FROM openjdk:8

ENV PORT = 8080

EXPOSE 8080

COPY . /code

RUN cd /code \
    && ./gradlew -g ./cache bootRepackage --stacktrace \
    && mv ./build/libs/demo-app.jar /app.jar \
    && mv Dockerfile /Dockerfile \
    && ./gradlew --stop \
    && sleep 4 \
    && cd /

CMD ["java", "-jar", "/app.jar"]