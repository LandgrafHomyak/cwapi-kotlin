package io.github.landgrafhomyak.cwapi.client

import com.rabbitmq.client.Channel
import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import io.github.landgrafhomyak.cwapi.messages.Message

open class SimpleSyncClient(
    final override val protocol: String = "amqps",
    final override val host: String,
    final override val port: UShort = 5673u,
    final override val instanceName: String,
    private val password: String
) : CwApiClient.Sync {
    //    private class ConnectionInfo(
//        val connection: Connection,
//        val channel: Channel,
//        val queue`
//    )
    companion object {
        @JvmStatic
        private val connectionFactory = ConnectionFactory()
    }

    private val connectionLink = "${this.protocol}://${this.instanceName}:${this.password}@${this.host}:${this.port}/"

    private var connectionAndChannel: Pair<Connection, Channel>? = null

    private val mutex = Any()

    override fun connect() {
        synchronized(this.mutex) {
            if (this@SimpleSyncClient.isConnected()) {
                throw IllegalStateException("Client is already connected")
            }
            val connection = connectionFactory.newConnection(this@SimpleSyncClient.connectionLink)
            val channel = connection.createChannel()
            channel.queuePurge(this@SimpleSyncClient.inputQueueName)
            this@SimpleSyncClient.connectionAndChannel = connection to channel
        }
    }

    override fun disconnect() {
        synchronized(this.mutex) {
            if (!this@SimpleSyncClient.isConnected()) {
                throw IllegalStateException("Client not connected")
            }
            val (connection, channel) = this@SimpleSyncClient.connectionAndChannel!!
            channel.close()
            connection.close()
            this@SimpleSyncClient.connectionAndChannel = null
        }
    }

    override fun askOrError(request: Message.Client2Server): Message.Server2Client {
        synchronized(this.mutex) {
            if (!this@SimpleSyncClient.isConnected()) {
                throw IllegalStateException("Client not connected")
            }
            val channel = this@SimpleSyncClient.connectionAndChannel!!.second
            channel.basicPublish(
                this@SimpleSyncClient.outputExchangeName,
                this@SimpleSyncClient.routingKey,
                null,
                request.toJson().toByteArray()
            )

            channel.basicConsume(this.inputQueueName) {

            }
        }
    }

    override fun isConnected(): Boolean = this.connectionAndChannel != null

}