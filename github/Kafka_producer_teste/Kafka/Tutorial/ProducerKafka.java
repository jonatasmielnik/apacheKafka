package com.github.Kafka_producer_teste.Kafka.Tutorial;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerKafka {
    public static void main(String[] args) {
        String bootstrapSevers = "127.0.0.1:9092";

        // create producer properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapSevers );
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // create producer
        KafkaProducer<String, String> producer =
                new KafkaProducer<String, String>(properties);

        for (int a=0;a<601;a++) {
            //create a producer record
            ProducerRecord<String, String> record =
                    new ProducerRecord<String, String>("first_topic", "Teste numero " + Integer.toString(a));

        // send data
        producer.send(record);
        }
        // flush data
        producer.flush();

        // flush and close data
        producer.close();
    }
}
