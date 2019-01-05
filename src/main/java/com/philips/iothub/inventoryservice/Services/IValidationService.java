package com.philips.iothub.inventoryservice.Services;

import java.io.IOException;

public interface IValidationService {

	Boolean ValidateDevice(String iotHubId, String inventoryId) throws IOException;
}