package org.nov0.persistance.model;

import org.nov0.persistance.constraints.Id;
import org.nov0.persistance.constraints.NotNull;
import org.nov0.persistance.constraints.Size;

public class Address {

	@Id
	private long id;
	
	@NotNull
	@Size(100)
	private String street;
	
	@Size(100)
	private String streetNumber;
	
	@NotNull
	@Size(25)
	private String City;
	
	@NotNull
	private int zipCode;

	public Address() {
	}

	public Address(String street, String streetNumber, String city, int zipCode) {
		this.street = street;
		this.streetNumber = streetNumber;
		City = city;
		this.zipCode = zipCode;
	}

	public Address(long id, String street, String streetNumber, String city, int zipCode) {
		this.street = street;
		this.streetNumber = streetNumber;
		City = city;
		this.zipCode = zipCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
