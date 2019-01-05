package com.philips.iothub.inventoryservice.Controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.iothub.inventoryservice.model.DeviceRequest;

public interface IInventoryServiceController {

	ObjectNode inventorizeRestEndpoint(@RequestBody DeviceRequest deviceRequest) throws IOException;

}