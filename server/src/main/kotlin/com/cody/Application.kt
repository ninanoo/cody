package com.cody

import com.cody.model.DatabaseSingleton
import com.cody.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    DatabaseSingleton.init(
        environment.config.property("ktor.application.datasource.url").getString(),
        environment.config.property("ktor.application.datasource.driverClassName").getString()
    )

    configureRouting()
}
