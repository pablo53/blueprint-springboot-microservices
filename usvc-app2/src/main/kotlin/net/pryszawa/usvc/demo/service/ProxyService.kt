package net.pryszawa.usvc.demo.service

import net.pryszawa.usvc.demo.conector.UsvcAppConnector
import org.springframework.stereotype.Service

@Service
class ProxyService(
    private val usvcAppConnector: UsvcAppConnector,
) {

    fun getProxyEcho(message: String): String =
        usvcAppConnector.getEcho(message).body!!

}