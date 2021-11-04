#!/bin/sh

set -e
umask 0027

source $DE_STARTUP_DIR/helper.sh

loginfo "Running DE Auth server boot scripts..."
for script in $(ls -1 $DE_BOOT/*.sh)
do
	. $script;
done
loginfo "Completed execution of all DE Auth server boot scripts..."

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

if [[ -z "${DE_LIB_DIR}" ]]; then
    loginfo "DE service variable DE_LIB_DIR is not set. Default value '/opt/DE/lib' will be used."
    DE_LIB_DIR="/opt/DE/lib"
fi



loginfo "Starting DE AUTH server..."
exec ${JAVA_HOME}/jre/bin/java -Dspring.config.location=file:$DE_CONF_DIR/application.properties  -Djavax.net.ssl.trustStorePassword=dataelicit@01 -Djavax.net.ssl.trustStore=$DE_CONF_DIR/de.truststore  -jar $DE_LIB_DIR/app.jar



