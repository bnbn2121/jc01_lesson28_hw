package com.edu.less28.hotel.util;

import com.edu.less28.hotel.model.Resident;

public class ResidentParser implements HotelParser {

	private static ResidentParser instance;

	private ResidentParser() {
	}

	public static ResidentParser getInstance() {
		if (instance == null) {
			instance = new ResidentParser();
		}
		return instance;
	}

	@Override
	public String parseToSrting(Object hotelObject) {
		if (hotelObject == null) {
			return "no resident";
		}
		Resident resident = (Resident) hotelObject;
		String residentData = "%s | %s | %s".formatted(
				resident.getFirstName(), 
				resident.getLastName(),
				resident.getPhoneNumber());
		return residentData;
	}

	@Override
	public Resident parseFromString(String stringData) {
		if (stringData.equals("no resident")) {
			return null;
		}
		String[] arrayData = stringData.split("\\|");
		Resident resident = new Resident(
				arrayData[0].trim(), 
				arrayData[1].trim(), 
				arrayData[2].trim());
		return resident;
	}

}
