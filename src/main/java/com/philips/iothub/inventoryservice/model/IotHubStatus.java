package com.philips.iothub.inventoryservice.model;

public enum IotHubStatus {
	initialized(1), inventorized(2), commissioned(3), decommissioned(4);

	private final int status;

	IotHubStatus(int status) {
		this.status = status;
	}

	public int getValue() {
		return status;
	}
}
