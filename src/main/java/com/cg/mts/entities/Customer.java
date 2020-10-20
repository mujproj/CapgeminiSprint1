package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends AbstractUser {
	@Id

	private int customerId;

	public Customer(String username, String password, String mobileNumber, String email, int customerId) {
		super(username, password, mobileNumber, email);
		this.customerId = customerId;
	}

	public Customer() {
		super();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
