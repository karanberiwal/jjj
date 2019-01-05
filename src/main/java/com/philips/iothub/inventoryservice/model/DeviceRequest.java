package com.philips.iothub.inventoryservice.model;

public class DeviceRequest {

	private String token;

	private String iotHubId;

	private String inventoryId;

	public String getInventoryId() {
		return inventoryId;
	}

	public String getIotHubId() {
		return iotHubId;
	}

	public String getToken() {
		return token;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public void setIotHubId(String iotHubId) {
		this.iotHubId = iotHubId;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
