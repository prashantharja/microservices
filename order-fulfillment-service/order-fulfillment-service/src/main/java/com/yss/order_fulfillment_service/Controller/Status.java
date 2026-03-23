package com.yss.order_fulfillment_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Status {

	@GetMapping("/status")
	public String getStatus() {
		return "Order Fulfillment Service status is : up and running!";
	}

}
