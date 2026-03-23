package com.yss.order_fulfillment_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yss.order_fulfillment_service.Client.InventoryClient;

@RestController
@RequestMapping("/orders")
public class Status {

	@Autowired
	InventoryClient inventoryClient;

	@GetMapping("/status")
	public String getStatus() {
		
		String inventoryResponse = inventoryClient.checkStock();
		return "Order Fulfillment Service status is : up and "
				+ "running! -> " + inventoryResponse;
	}

}
