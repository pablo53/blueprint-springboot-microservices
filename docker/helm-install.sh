#!/usr/bin/env sh

. ./helm-env.sh

helm install usvc --set "local.volumes.path=$CHARTDIR/volume" --set "security.uid=$UID"  --set "security.gid=$GID" .
