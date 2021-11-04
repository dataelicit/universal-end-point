#!/bin/sh

DE_LAUNCH_LOG_PREFIX=${DE_LAUNCH_LOG_PREFIX:-}

function loginfo {
    echo "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][INFO]: $@"
}

function logwarn {
    echo "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][WARN]: $@"
}

function logerror {
    echo "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][ERROR]: $@"
}

