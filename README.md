# RaceManagerApplication

Race manager Springboot app using Springboot MVC, Spring data, Mysql, Kafka. Architecture is hexagonal.

Required :

- Java 21
- Docker

## Build

```bash
./gradlew compileJava 
```

## Test

```bash
./gradlew test 
```

## Local Run

Start mysql and kafka

```bash
docker-compose -f docker-compose.yml up
```

Start the app

```bash
./gradlew bootRun # using jdk 21 -> upgrade your JAVA_HOME env var 
```

## Create race

```bash
curl -X POST --location "http://127.0.0.1:8080/races" \
    -H "Content-Type: application/json" \
    -d '{
          "date": "2023-07-31",
          "number": 1,
          "name": "Course de Paris",
          "starters": [
            {
              "number": 1,
              "name": "toto"
            },
            {
              "number": 2,
              "name": "tata"
            }
          ]
        }' 
```

## TODO

- Implement validation on the rule "Une course a lieu un jour donné et possède un nom et un numéro unique pour ce jour ;"
- Implement Kafka dto and mapping
- Add missing tests
- Add Exception handlers
- Add profiled properties files (local)
- Add loggers
- Clean code (useless lombok annot constructor)
