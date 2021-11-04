#!/bin/sh

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

if [[ -z "${DE_DB_SVC_NAME}" ]]; then
    loginfo "DE service variable DE_DB_SVC_NAME is not set. Default value 'localhost' will be used."
    DE_DB_SVC_NAME="localhost"
fi

if [[ -z "${DE_DB_SVC_PORT}" ]]; then
    loginfo "DE service variable DE_DB_SVC_PORT is not set. Default value '5432' will be used."
    DE_DB_SVC_PORT="5432"
fi

if [[ -z "${DE_DB_SVC_DATABASE_NAME}" ]]; then
    loginfo "DE service variable DE_DB_SVC_DATABASE_NAME is not set. Default value 'postgres' will be used."
    DE_DB_SVC_DATABASE_NAME="postgres"
fi

if [[ -z "${DE_DB_SVC_USER_NAME}" ]]; then
    loginfo "DE service variable DE_DB_SVC_USER_NAME is not set. Default value 'postgres' will be used."
    DE_DB_SVC_USER_NAME="postgres"
fi

if [[ -z "${DE_DB_SVC_PASSWORD}" ]]; then
    loginfo "DE service variable DE_DB_SVC_PASSWORD is not set. Default value 'postgres' will be used."
    DE_DB_SVC_PASSWORD="postgres"
fi

DE_DB_JDBC_URL="jdbc:postgresql://$DE_DB_SVC_NAME:$DE_DB_SVC_PORT/$DE_DB_SVC_DATABASE_NAME"


loginfo "Database JDBC URL:$DE_DB_JDBC_URL"

echo "

spring.datasource.url= $DE_DB_JDBC_URL
spring.datasource.username= $DE_DB_SVC_USER_NAME
spring.datasource.password= $DE_DB_SVC_PASSWORD

" >> $DE_CONF_DIR/application.properties
