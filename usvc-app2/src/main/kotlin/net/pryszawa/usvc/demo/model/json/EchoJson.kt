package net.pryszawa.usvc.demo.model.json

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import net.pryszawa.usvc.demo.model.canonical.Echo

@JsonInclude(JsonInclude.Include.NON_NULL)
class EchoJson(

    @JsonProperty("message")
    override val message: String,

) : Echo {

    constructor(other: Echo) : this(
        message = other.message,
    )

}
