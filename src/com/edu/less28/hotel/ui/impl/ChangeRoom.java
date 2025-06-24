package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.model.TypeRoom;
import com.edu.less28.hotel.ui.ConsoleCommand;
import com.edu.less28.hotel.ui.ConsoleUI;

public class ChangeRoom implements ConsoleCommand {

	@Override
	public String getRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.CHANGE_ROOM).append("\n");
		int id = ConsoleUI.userIntInput("enter room id:");
		String type = ConsoleUI.userStringInput("enter type (STANDART, COMFORT, LUX) of room:").toUpperCase();
		TypeRoom typeRoom = TypeRoom.valueOf(type);
		String isBooked = ConsoleUI.userStringInput("enter status (booked / free) of room:");
		sb.append(id).append(" | ");
		sb.append(typeRoom).append(" | ");
		sb.append(isBooked).append(" | ");
		if (isBooked.equals("free")) {
			sb.append("no resident");
		} else {
			String residentFirstName = ConsoleUI.userStringInput("enter resident first name:");
			String residentLastName = ConsoleUI.userStringInput("enter resident last name:");
			String residentPhoneNumber = ConsoleUI.userStringInput("enter resident phone number:");
			sb.append(residentFirstName).append(" | ");
			sb.append(residentLastName).append(" | ");
			sb.append(residentPhoneNumber);
		}
		String request = sb.toString();
		return request;
	}
	
}
