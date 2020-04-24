FROM maven:3-openjdk-11

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

ADD . /usr/src/app

RUN mvn install package -DskipTests

ENTRYPOINT [""]
CMD ["sh", "-c", "java -cp target/data-import-communecter-1.0-SNAPSHOT-jar-with-dependencies.jar com.eiko.app.importers.communecter.App"]