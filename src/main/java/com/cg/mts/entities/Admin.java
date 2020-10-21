package com.cg.mts.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser {
	@Id
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Admin(String username, String password, String mobileNumber, String email, int adminId) {
		super(username, password, mobileNumber, email);
		this.adminId = adminId;
	}

	public Admin() {
		super();
	}
}