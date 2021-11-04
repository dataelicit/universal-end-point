#!/bin/sh

if [[ -z "${DE_CONF_DIR}" ]]; then
    loginfo "DE service variable DE_CONF_DIR is not set. Default value '/opt/DE/conf' will be used."
    DE_CONF_DIR="/opt/DE/conf"
fi

loginfo "Setting server SSL properties."
echo "security.require-ssl=true
server.ssl.protocol=TLS
server.ssl.enabled-protocols=TLSv1.3,TLSv1.2
server.ssl.ciphers=TLS_AES_256_GCM_SHA384,TLS_CHACHA20_POLY1305_SHA256,TLS_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384
server.ssl.key-store=$DE_CONF_DIR/de.keystore
server.ssl.keyAlias=de
server.ssl.keyStoreType=PKCS12
server.ssl.key-store-password=dataelicit@01

server.ssl.key-store-type=PKCS12
server.ssl.trust-store-type=PKCS12
server.ssl.trust-store=$DE_CONF_DIR/de.truststore
server.ssl.trust-store-password=dataelicit@01
server.ssl.enabled=true" >> $DE_CONF_DIR/application.properties

