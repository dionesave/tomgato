FROM openjdk:20
VOLUME /tmp
ADD tomgato/target/tomgato-0.0.1-SNAPSHOT.jar tomgato.jar
EXPOSE 8081
RUN bash -c 'touch /tomgato.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/tomgato.jar"]
