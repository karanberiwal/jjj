package com.philips.iothub.inventoryservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventoryinfo")
public class InventoryInfoEntity {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "iothubid", unique = true, nullable = false)
	private String iotHubId;

	@Column(name = "inventoryid", unique = true, nullable = false)
	private String inventoryId;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "statusid", referencedColumnName = "statusid")
	private StatusInfoEntity statusInfoEntity;

	public InventoryInfoEntity() {
		super();
	}

	public String getHubid() {
		return iotHubId;
	}

	public int getId() {
		return id;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public StatusInfoEntity getStatusInfoEntity() {
		return statusInfoEntity;
	}

	public void setHubId(String iotHubId) {
		this.iotHubId = iotHubId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public void setStatusInfoEntity(StatusInfoEntity statusInfoEntity) {
		this.statusInfoEntity = statusInfoEntity;
	}

}
