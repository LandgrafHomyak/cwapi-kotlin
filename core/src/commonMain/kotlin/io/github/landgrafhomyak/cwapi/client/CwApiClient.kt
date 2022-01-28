package io.github.landgrafhomyak.cwapi.client

import io.github.landgrafhomyak.cwapi.messages.CreateAuthCodeRequest
import io.github.landgrafhomyak.cwapi.messages.CreateAuthCodeResponse
import io.github.landgrafhomyak.cwapi.messages.ErrorMessage
import io.github.landgrafhomyak.cwapi.messages.Message

sealed interface CwApiClient {
    val instanceName: String
//    val connectionLink: String
    val protocol: String
    val host: String
    val port: UShort
    val outputExchangeName: String
        get() = "${this.instanceName}_o"
    val inputQueueName: String
        get() = "${this.instanceName}_i"
    val routingKey: String
        get() = "${this.instanceName}_ex"

    fun isConnected(): Boolean

    interface Sync : CwApiClient {
        fun connect()
        fun disconnect()
        fun askOrError(request: Message.Client2Server): Message.Server2Client

        @Throws(ErrorMessage::class)
        fun ask(request: Message.Client2Server): Message.Server2Client =
            this.askOrError(request).let { response ->
                if (response is ErrorMessage) throw response
                else response
            }

        //@Throws(ErrorMessage::class)
        fun ask(request: CreateAuthCodeRequest): CreateAuthCodeResponse =
            this.ask(request as Message.Client2Server).let { response ->
                if (response is CreateAuthCodeResponse) response
                else throw RuntimeException()
            }
    }

    interface Async : CwApiClient {
        suspend fun connect()
        suspend fun disconnect()
        suspend fun askOrError(request: Message.Client2Server): Message.Server2Client

        //        @Throws(ErrorMessage::class)
        suspend fun ask(request: Message.Client2Server): Message.Server2Client =
            this.askOrError(request).let { response ->
                if (response is ErrorMessage) throw response
                else response
            }

        //@Throws(ErrorMessage::class)
        suspend fun ask(request: CreateAuthCodeRequest): CreateAuthCodeResponse = this.ask(request as Message.Client2Server).let { response ->
            if (response is CreateAuthCodeResponse) response
            else throw RuntimeException()
        }
    }
}
