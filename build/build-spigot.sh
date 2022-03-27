#!/bin/bash

cd $(dirname "$0")
./env.sh build-tools --remapped --generate-source --generate-docs
