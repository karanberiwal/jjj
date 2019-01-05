package com.philips.iothub.inventoryservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.philips.iothub.inventoryservice.model.InventoryInfoEntity;


public  interface InventoryRepository extends CrudRepository <InventoryInfoEntity, Integer>{
	
	@Query("select statusinfo.Status from InventoryInfoEntity inventoryinfo inner join inventoryinfo.statusInfoEntity statusinfo where inventoryinfo.iotHubId = :iotHubId and inventoryinfo.inventoryId = :inventoryId")
	String FindStatusByIdAndCode(@Param("iotHubId") String iotHubId, @Param("inventoryId") String inventoryId);

	@Modifying
	@Transactional
	@Query("update InventoryInfoEntity set statusid = :statusId where iotHubId = :iotHubId")
	void InventorizeHub(@Param("iotHubId") String iotHubId, @Param("statusId") int statusId);
	
}
