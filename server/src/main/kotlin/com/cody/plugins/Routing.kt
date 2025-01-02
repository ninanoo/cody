package com.cody.plugins

import com.cody.controller.CodyController
import com.cody.exceptions.DbElementInsertException
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import kotlin.text.toInt
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            if (cause is DbElementInsertException) {
                call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
            } else {
                call.respondText(text = "400: $cause", status = HttpStatusCode.BadRequest)
            }
        }
    }
    routing {
        route("cody") {
            post("putBrand") {
                val form = call.receiveParameters()

                // TODO 폼 덩어리 그대로 통으로 객체로 바이패스

                call.respond(
                        Json.encodeToString(
                                CodyController()
                                        .putBrand(
                                                form.getOrFail("name"),
                                                form.getOrFail("total").toInt(),
                                                form.getOrFail("cat1").toInt(),
                                                form.getOrFail("cat2").toInt(),
                                                form.getOrFail("cat3").toInt(),
                                                form.getOrFail("cat4").toInt(),
                                                form.getOrFail("cat5").toInt(),
                                                form.getOrFail("cat6").toInt(),
                                                form.getOrFail("cat7").toInt(),
                                                form.getOrFail("cat8").toInt()
                                        )
                        )
                )
            }

            get("getBrandList") {
                call.respond(Json.encodeToString(CodyController().getBrandList()))
            }

            get("getExam1List") {
                call.respond(Json.encodeToString(CodyController().getExam1List()))
            }

            get("getExam2List") {
                call.respond(Json.encodeToString(CodyController().getExam2List()))
            }

            get("getExam3List/{catNo}") {
                call.respond(
                        Json.encodeToString(
                                CodyController()
                                        .getExam3List((call.parameters["catNo"] ?: "8").toInt())
                        )
                )
            }

            post("delBrand") {
                val form = call.receiveParameters()
                val id = form.getOrFail("id").toInt()

                call.respond(Json.encodeToString(CodyController().delBrand(id)))
            }
        }
    }
}
