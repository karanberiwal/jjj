package com.philips.iothub.ControllerTest;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.philips.iothub.inventoryservice.Controller.InventoryServiceController;
import com.philips.iothub.inventoryservice.Services.IValidationService;
import com.philips.iothub.inventoryservice.model.DeviceRequest;

public class InventoryServiceControllerTest {

	@InjectMocks
	InventoryServiceController inventoryServiceController;
	
	@Mock
	IValidationService validationService;
	
	@BeforeEach
	public void init_mocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void inventorizeEndPoint_ValidInput_DeviceIsInventorised() throws IOException
	{
		//Arrange
		DeviceRequest request = new DeviceRequest();
		request.setIotHubId("DemoDeviceId");
		request.setInventoryId("DemoInventorisedId");
		Mockito.when(validationService.ValidateDevice(request.getIotHubId(), request.getInventoryId())).thenReturn(true);
		
		//Act
		ObjectNode node = inventoryServiceController.inventorizeRestEndpoint(request);
				
		//Assert
		Assertions.assertEquals(node.findValue("Authorized"), com.fasterxml.jackson.databind.node.BooleanNode.TRUE);
	}
	
	@Test
	public void inventorizeEndPoint_invalidInput_DeviceIsNotINventorised() throws IOException
	{
		//Arrange
		DeviceRequest request = new DeviceRequest();
		request.setIotHubId("DemoDeviceId");
		request.setInventoryId("DemoInventorisedId");
		Mockito.when(validationService.ValidateDevice(request.getIotHubId(), request.getInventoryId())).thenReturn(false);
				
		//Act
		ObjectNode node = inventoryServiceController.inventorizeRestEndpoint(request);
						
		//Assert
		Assertions.assertEquals(node.findValue("Authorized"), com.fasterxml.jackson.databind.node.BooleanNode.FALSE);
	}
}

