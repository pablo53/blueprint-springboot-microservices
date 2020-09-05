export CONSUL_DATA_DIR=$(pwd)/volume/consul/data
export CONSUL_CONFIG_DIR=$(pwd)/volume/consul/config
mkdir -p "${CONSUL_DATA_DIR}"
mkdir -p "${CONSUL_CONFIG_DIR}"
