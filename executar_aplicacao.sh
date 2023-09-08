#!/bin/bash
# Executa o jar já com as dependencias completas da aplicação

mvn clean package

java -jar ./target/otica-1.0-SNAPSHOT-jar-with-dependencies.jar
