package com.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class KafkaProducerExample {
	public static void main(String[] args) {
		// Configure the producer
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092"); // Replace with your Kafka broker address
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// Create a Kafka producer
		Producer<String, String> producer = new KafkaProducer<>(props);

		// Send a message to the "my-topic" topic
		ProducerRecord<String, String> record = new ProducerRecord<>("my-topic", "key", "Hello, Kafka!");
		producer.send(record);

		// Close the producer
		producer.close();
	}
}
