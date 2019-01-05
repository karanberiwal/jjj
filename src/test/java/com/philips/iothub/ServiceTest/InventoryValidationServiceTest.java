package com.philips.iothub.ServiceTest;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.philips.iothub.inventoryservice.Services.InventoryValidationService;
import com.philips.iothub.inventoryservice.repository.InventoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class InventoryValidationServiceTest {
	
	@InjectMocks
	InventoryValidationService inventoryValidationService;
	
	@Mock
	private InventoryRepository inventoryRepository;
	

	
	
	
	@Test
	public void ValidateDevice_ValidInput_AldreadyInventorized_ReturnTrue() throws IOException
	{
		//Arrange
		when(inventoryRepository.FindStatusByIdAndCode("DemoDeviceId", "DemoInventorisedId")).thenReturn("Inventorized");
		
		
		//Act
		Boolean result=inventoryValidationService.ValidateDevice("DemoDeviceId", "DemoInventorisedId");
		
		//Assert
		assertTrue(result, "Device validation succeeded, returned true");
	}
	
	
	@Test
	public void ValidateDevice_InValidInput_ReturnFalse() throws IOException
	{
		//Arrange
		when(inventoryRepository.FindStatusByIdAndCode("DemoDeviceId", "DemoInventorisedId")).thenReturn("");
		
		
		//Act
		Boolean result=inventoryValidationService.ValidateDevice("DemoDeviceId", "DemoInventorisedId");
		
		//Assert
		assertFalse(result, "Device validation succeeded, returned true");
	}
	
	
	@Test
	public void ValidateInventorizedDevice_ValidInput_ReturnFalse() throws IOException
	{
		//Arrange
		when(inventoryRepository.FindStatusByIdAndCode("DemoDeviceId", "DemoInventorisedId")).thenReturn("initialized");
		
		
		//Act
		Boolean result=inventoryValidationService.ValidateDevice("DemoDeviceId", "DemoInventorisedId");
		
		//Assert
		assertTrue(result, "Device validation succeeded, returned true");
	}
}
