FROM openjdk:11

VOLUME /src

EXPOSE 8766  

ADD ./target/tendencia-0.0.1-SNAPSHOT.jar leozin89/tendencia.jar

ENTRYPOINT ["java","-jar","leozin89/tendencia.jar"]