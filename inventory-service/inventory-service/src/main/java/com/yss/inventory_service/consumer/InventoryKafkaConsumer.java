package com.yss.inventory_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryKafkaConsumer {
	
	// ADD THIS CONSTRUCTOR: 
    // This will print to the console the exact millisecond Spring Boot creates this class.
    public InventoryKafkaConsumer() {
        System.out.println("======================================================");
        System.out.println("🎯 SPRING BOOT HAS CREATED THE KAFKA CONSUMER BEAN 🎯");
        System.out.println("======================================================");
    }
	
	@KafkaListener(topics = "order-events", groupId = "inventory-group")
	public void consumeOrderEvent(String message) {
		
		System.out.println("=========================================");
        System.out.println("KAFKA MESSAGE RECEIVED IN INVENTORY SERVICE:");
        System.out.println(message);
        System.out.println("Processing inventory update in the background...");
        System.out.println("=========================================");
		
	}
}
