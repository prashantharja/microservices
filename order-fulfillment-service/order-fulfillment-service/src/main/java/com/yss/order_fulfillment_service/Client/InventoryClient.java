package com.yss.order_fulfillment_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

	// This matches the exact method signature of the target controller
	@GetMapping("/inventory/check")
	String checkStock();
}
