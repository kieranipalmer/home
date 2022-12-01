package dev.shanty.home.server

import dev.shanty.akt.runLocalActorSystem
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import dev.shanty.refrakt.Lifx

fun main() = runLocalActorSystem {

    val lifx = Lifx(this)

    embeddedServer(Netty) {

    }

}
