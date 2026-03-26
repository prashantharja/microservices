package com.yss.order_fulfillment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yss.order_fulfillment_service.client.InventoryClient;

@RestController
@RequestMapping("/orders")
public class Status {

	// --- SYNCHRONOUS DEPENDENCY (OpenFeign) ---
	@Autowired
	InventoryClient inventoryClient;

	// Endpoint 1: Synchronous read using OpenFeign
	@GetMapping("/status")
	public String getStatus() {

		String inventoryResponse = inventoryClient.checkStock();
		return "Order Fulfillment Service status is : up and " + "running! -> " + inventoryResponse;
	}

	// --- ASYNCHRONOUS DEPENDENCY (Kafka) ---
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	private static final String TOPIC = "order-events";

	// Endpoint 2: Asynchronous write using Kafka
	@GetMapping("/place")
	public String placeOrder(@RequestParam("item") String item) {
		String message = "New order placed for item: " + item;
		kafkaTemplate.send(TOPIC, message);
		return "Order received instantly! Background processing has started for: " + item;
	}

}
