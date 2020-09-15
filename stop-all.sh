#!/usr/bin/env sh

curl 'http://localhost:8081/actuator/shutdown' -i -X POST
curl 'http://localhost:8082/actuator/shutdown' -i -X POST
curl 'http://localhost:8083/actuator/shutdown' -i -X POST
curl 'http://localhost:8084/actuator/shutdown' -i -X POST
