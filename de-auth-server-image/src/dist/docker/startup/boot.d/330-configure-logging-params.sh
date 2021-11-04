#!/bin/sh

if [[ -z "${DE_LOG_DIR}" ]]; then
    loginfo "DE service variable DE_LOG_DIR is not set. Default value '/opt/DE/log' will be used."
    DE_LOG_DIR="/opt/DE/log"
fi

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

echo "
spring.profiles.active=production

#Logging configuration

logging.config=$DE_CONF_DIR/logback-spring.xml
logging.level.root=${DE_LOG_LEVEL}
logging.level.com.de=${DE_LOG_APP_LEVEL}
logging.path=${DE_LOG_DIR}
logging.log-max-file-size=${DE_LOG_MAX_FILE_SIZE}
logging.max-history=${DE_LOG_MAX_HISTORY}
logging.file-name=${DE_APP_NAME}
logging.pattern.file=$DE_LOG_PATTERN [%t] %-40.40logger{39} : %m%n%wEx
logging.pattern.console=$DE_LOG_PATTERN : %m%n%wEx
"  >> $DE_CONF_DIR/application.properties