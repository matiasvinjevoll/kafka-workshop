package tasks

import io.bekk.config.KafkaConfig
import io.bekk.publisher.BekkbookStatusMessage
import org.apache.kafka.clients.producer.ProducerRecord
import java.util.*

// Task_5

// Produce an Avro-serialized message to the topic "bekkbook-status-message"

fun main() {

    BarebonesKafkaClients.getAvroProducer<BekkbookStatusMessage>().use { producer ->
        producer.send(
            ProducerRecord(
                Constants.AVRO_TOPIC_NAME,
                UUID.randomUUID().toString(),
                BekkbookStatusMessage("\"It doesn't seem like anything to me.\"")
            )
        )
    }
}