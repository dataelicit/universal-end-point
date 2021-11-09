#!/bin/sh

DE_LAUNCH_LOG_PREFIX=${DE_LAUNCH_LOG_PREFIX:-}
DE_LOG_DIR=${DE_LOG_DIR:-/opt/DE/log}

function loginfo {
    log "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][INFO]: $@"
}

function logwarn {
    log "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][WARN]: $@"
}

function logerror {
    log "[${DE_LAUNCH_LOG_PREFIX}][`date +\"%F %T\"`][ERROR]: $@"
}

function log {
    echo "$@" >> $DE_LOG_DIR/$DE_LAUNCH_LOG_PREFIX.log 2>&1
    echo "$@"
}

