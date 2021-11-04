#!/bin/sh

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

loginfo "Copying configuration files to $DE_CONF_DIR "
mkdir -p $DE_CONF_DIR
cp -rf $DE_STARTUP_DIR/conf/* $DE_CONF_DIR/

