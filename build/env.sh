#!/bin/bash

cd $(dirname "$0")

docker compose up -d
docker exec -it outer-space-build-env ${@:-/bin/sh}
docker compose down
