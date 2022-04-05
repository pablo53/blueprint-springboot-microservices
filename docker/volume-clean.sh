#!/usr/bin/env sh

. ./docker-compose-env.sh

read -p "Are You sure You want to remove all the docker volumes (y/N)?" cfrm
case "$cfrm" in
	y|Y)
		sudo rm -rf ${CONSUL_DATA_DIR}
		sudo rm -rf ${POSTGRES_DATA_DIR}
		sudo rm -rf ${MONGO_DATA_DIR}
		sudo rm -rf ${JAEGER_DATA_DIR}
		sudo rm -rf ${ZOOKEPER_DATA_DIR}
		sudo rm -rf ${ZOOKEPER_DATALOG_DIR}
		sudo rm -rf ${ZOOKEPER_LOGS_DIR}
		echo "Docker volumes cleaned up."
		;;
	n|N)
		;;
	*)
		echo "Incorrect answer."
		;;
esac

