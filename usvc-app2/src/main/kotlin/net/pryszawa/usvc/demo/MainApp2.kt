package net.pryszawa.usvc.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["net.pryszawa.usvc.demo"])
class MainApp2


fun main(args: Array<String>) {
    runApplication<MainApp2>(args = *args)
}
