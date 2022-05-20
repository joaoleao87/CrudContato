FROM openjdk
COPY  target/CrudContato-0.0.1-SNAPSHOT.jar /usr/local/CrudContato-0.0.1-SNAPSHOT.jar
EXPOSE 8080
WORKDIR /usr/local
ENTRYPOINT [ "java", "-jar", "CrudContato-0.0.1-SNAPSHOT.jar" ]