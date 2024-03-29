export UID=$(id -u)
export GID=$(id -g)
export CONSUL_DATA_DIR=$(pwd)/volume/consul/data
export CONSUL_CONFIG_DIR=$(pwd)/volume/consul/config
export POSTGRES_DATA_DIR=$(pwd)/volume/postgres/data
export POSTGRES2_DATA_DIR=$(pwd)/volume/postgres2/data
export POSTGRES3_DATA_DIR=$(pwd)/volume/postgres3/data
export MONGO_DATA_DIR=$(pwd)/volume/mongo/data
export MONGO_CONFIG_DIR=$(pwd)/volume/mongo/config
export LDAP_DATA_DIR=$(pwd)/volume/ldap/data
export LDAP_CONFIG_CERTS_DIR=$(pwd)/volume/ldap/config/certs
export PROMETHEUS_DATA_DIR=$(pwd)/volume/prometheus/data
export PROMETHEUS_CONFIG_DIR=$(pwd)/volume/prometheus/config
export JAEGER_DATA_DIR=$(pwd)/volume/jaeger/data
export ELK_DATA_DIR=$(pwd)/volume/elk/data
export KIBANA_CONFIG_DIR=$(pwd)/volume/kibana/config
export GRAFANA_DATA_DIR=$(pwd)/volume/grafana/data
export GRAFANA_CONFIG_DIR=$(pwd)/volume/grafana/config
export ZOOKEPER_DATA_DIR=$(pwd)/volume/zookeeper/data
export ZOOKEPER_DATALOG_DIR=$(pwd)/volume/zookeeper/datalog
export ZOOKEPER_LOGS_DIR=$(pwd)/volume/zookeeper/logs

mkdir -p "${CONSUL_DATA_DIR}"
mkdir -p "${CONSUL_CONFIG_DIR}"
mkdir -p "${POSTGRES_DATA_DIR}"
mkdir -p "${POSTGRES2_DATA_DIR}"
mkdir -p "${POSTGRES3_DATA_DIR}"
mkdir -p "${MONGO_DATA_DIR}"
mkdir -p "${MONGO_CONFIG_DIR}"
mkdir -p -m 777 "${LDAP_DATA_DIR}"
mkdir -p -m 777 "${LDAP_CONFIG_CERTS_DIR}"
mkdir -p "${PROMETHEUS_DATA_DIR}"
mkdir -p "${PROMETHEUS_CONFIG_DIR}"
mkdir -p "${JAEGER_DATA_DIR}"
mkdir -p "${ELK_DATA_DIR}"
mkdir -p "${KIBANA_CONFIG_DIR}"
mkdir -p "${GRAFANA_DATA_DIR}"
mkdir -p "${GRAFANA_CONFIG_DIR}"
mkdir -p "${ZOOKEPER_DATA_DIR}"
mkdir -p "${ZOOKEPER_DATALOG_DIR}"
mkdir -p "${ZOOKEPER_LOGS_DIR}"
