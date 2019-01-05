package com.philips.iothub.inventoryservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.philips.iothub" })
public class IothubInventoryserviceApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(IothubInventoryserviceApplication.class, args);
	}
}
