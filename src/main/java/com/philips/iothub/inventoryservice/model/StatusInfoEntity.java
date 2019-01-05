// (C) Koninklijke Philips Electronics N.V. 2018

//

// All rights are reserved. Reproduction or transmission in whole or in part,

// in  any form or by any means, electronic, mechanical or otherwise, is

// prohibited without the prior written permission of the copyright owner.

//

//Filename   :StatusInfoEntity.Java

//

// Author     : Karan Beriwal

//

// Description : This class is responsible to map pojo data types to the status table in database
package com.philips.iothub.inventoryservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Does X and Y and provides an abstraction for Z.
 */
@Entity
@Table(name = "statusinfo")
public class StatusInfoEntity {
    @Id
	 @Column(name = "statusid", unique = true, nullable = false)
	 private int StatusId;

	 @Column(name = "status")
	 private String Status;

	 public StatusInfoEntity() {
		super();
	 }

	 public StatusInfoEntity(int statusid, String status) {
		StatusId = statusid;
	        Status = status;
	}

	 public String getStatus() {
		 return Status;
	 }

	 public int getStatusId() {
	 	return StatusId;
	 }

	 public void setStatus(String status) {
		Status = status;
	}

	 public void setStatusId(int statusid) {
		StatusId = statusid;
	}

}
