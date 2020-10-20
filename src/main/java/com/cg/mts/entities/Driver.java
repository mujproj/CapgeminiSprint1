package com.cg.mts.entities;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Driver extends AbstractUser {
	@Id
	private int driverId;
	private String licenseNo;
	@OneToOne
	private Cab cab;
	private float rating;
	@OneToMany(mappedBy = "driver")
	private List<TripBooking> list;

	public Driver(String username, String password, String mobileNumber, String email, int driverId, String licenseNo,
			Cab cab, float rating, List<TripBooking> list) {
		super(username, password, mobileNumber, email);
		this.driverId = driverId;
		this.licenseNo = licenseNo;
		this.cab = cab;
		this.rating = rating;
		this.list = list;
	}

	public Driver() {
		super();
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<TripBooking> getList() {
		return list;
	}

	public void setList(List<TripBooking> list) {
		this.list = list;
	}
}
