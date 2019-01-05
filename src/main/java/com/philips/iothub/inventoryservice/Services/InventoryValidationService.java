package com.philips.iothub.inventoryservice.Services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.iothub.inventoryservice.model.IotHubStatus;
import com.philips.iothub.inventoryservice.repository.InventoryRepository;

@Service("InventoryValidationService")
public class InventoryValidationService implements IValidationService {

	@Autowired
	private InventoryRepository inventoryRepository;
    
	@Override
	public Boolean ValidateDevice(String iotHubId, String inventoryId) throws IOException {
		String status = inventoryRepository.FindStatusByIdAndCode(iotHubId, inventoryId);
		
		 if(status.toUpperCase().equals(IotHubStatus.initialized.toString().toUpperCase()))
		{
			inventoryRepository.InventorizeHub(iotHubId, IotHubStatus.inventorized.getValue());
		}
		else if(status.equals(null) || status.isEmpty())
		{
			return false;
		}
		else if(status.toUpperCase().equals(IotHubStatus.inventorized.toString().toUpperCase()))
		{
			System.out.println("Hub is already inventorized");
		}
		return true;
	}
}
