FROM openjdk:8-jre-alpine
COPY target/restaurant_reservation-0.1.0.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD target/restaurant_reservation-0.1.0.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
#FROM java:8
#VOLUME /tmp
#ADD restaurant_reservation-0.1.0.jar app.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
