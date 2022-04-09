package net.pryszawa.usvc.demo.service

import net.pryszawa.usvc.demo.conector.UsvcAppConnector
import net.pryszawa.usvc.demo.model.dto.EchoDTO
import org.springframework.stereotype.Service

@Service
class ProxyService(
    private val usvcAppConnector: UsvcAppConnector,
) {

    fun getProxyEcho(message: String): EchoDTO =
        EchoDTO(
            message = usvcAppConnector.getEcho(message).body!!
        )

}