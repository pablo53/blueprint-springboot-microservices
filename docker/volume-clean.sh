#!/usr/bin/env sh

. ./docker-compose-env.sh

sudo rm -rf ${CONSUL_DATA_DIR}
sudo rm -rf ${POSTGRES_DATA_DIR}
sudo rm -rf ${MONGO_DATA_DIR}
