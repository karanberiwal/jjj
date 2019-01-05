package com.philips.iothub.inventoryservice.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.iothub.inventoryservice.Services.IValidationService;
import com.philips.iothub.inventoryservice.model.DeviceRequest;

@Controller("Inventorize Controller")
@RestController
@RequestMapping("/inventory")
public class InventoryServiceController {

	@Autowired
	IValidationService inventoryValidationService;

	@RequestMapping(value = "entry", method = RequestMethod.POST, headers = { "api-version=1" })
	public ObjectNode inventorizeRestEndpoint(@RequestBody DeviceRequest deviceRequest) throws IOException {
		ObjectNode objectNode = new ObjectMapper().createObjectNode();

		Boolean result = inventoryValidationService.ValidateDevice(deviceRequest.getIotHubId(),
				deviceRequest.getInventoryId());

		objectNode.put("Authorized", result);
		return objectNode;
	}
}
