package com.edu.less28.hotel.model;

import java.util.Objects;

public class Resident {
	private String firstName;
	private String lastName;
	private String phoneNumber;

	public Resident() {
	}

	public Resident(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public void setFirstName(String firstName) {
		if (this.firstName == null) {
			this.firstName = firstName;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		if (this.lastName == null) {
			this.lastName = lastName;
		}
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resident other = (Resident) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Resident [" + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (phoneNumber != null ? "phoneNumber=" + phoneNumber : "") + "]";
	}

	

}
