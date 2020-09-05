export CONSUL_DATA_DIR=$(pwd)/volume/consul/data
export CONSUL_CONFIG_DIR=$(pwd)/volume/consul/config
export POSTGRES_DATA_DIR=$(pwd)/volume/postgres/data
mkdir -p "${CONSUL_DATA_DIR}"
mkdir -p "${CONSUL_CONFIG_DIR}"
mkdir -p "${POSTGRES_DATA_DIR}"
