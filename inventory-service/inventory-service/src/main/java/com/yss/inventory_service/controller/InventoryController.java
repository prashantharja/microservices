package com.yss.inventory_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@RequestMapping("/check")
	public String checkStock() {
		return "[Inventory Service: Item is in stock!]";
	}
}
