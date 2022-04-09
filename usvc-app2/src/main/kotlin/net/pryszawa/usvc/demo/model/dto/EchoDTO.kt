package net.pryszawa.usvc.demo.model.dto

import net.pryszawa.usvc.demo.model.canonical.Echo

class EchoDTO(
    override val message: String,
) : Echo {

    constructor(other: Echo) : this(
        message = other.message,
    )

}
