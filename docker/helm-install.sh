#!/usr/bin/env sh

BASEDIR=$(dirname $(readlink -f "$0"))

echo "BASEDIR=$BASEDIR"

#. ./docker-compose-env.sh

helm install usvc --set "local.volumes.path=$BASEDIR/volume" .
