#!/usr/bin/env sh

. ./docker-compose-env.sh

docker-compose up -d $@
