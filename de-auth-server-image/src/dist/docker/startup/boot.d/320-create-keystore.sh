#!/bin/sh
set -e
umask 0027

if [[ -z "${DE_HOSTNAME}" ]]; then
    loginfo "DE service variable DE_HOSTNAME is not set. Default value 'localhost' will be used."
    DE_HOSTNAME="localhost"
fi

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

loginfo "Creating keystore and truststore"
$JAVA_HOME/bin/keytool -genkey -alias de -keyalg rsa -sigalg SHA256withRSA -keysize 2048 -dname "CN=$DE_HOSTNAME,OU=DE,O=DE,L=Bangalore,ST=KA,C=India" -keystore $DE_CONF_DIR/de.keystore -keypass dataelicit@01 -storepass dataelicit@01 -storetype PKCS12
$JAVA_HOME/bin/keytool -export -alias de -file $DE_CONF_DIR/de.cer -keystore $DE_CONF_DIR/de.keystore -storetype PKCS12 -storepass dataelicit@01
$JAVA_HOME/bin/keytool -import -alias de -file $DE_CONF_DIR/de.cer -noprompt -keystore $DE_CONF_DIR/de.truststore -storetype PKCS12 -storepass dataelicit@01

