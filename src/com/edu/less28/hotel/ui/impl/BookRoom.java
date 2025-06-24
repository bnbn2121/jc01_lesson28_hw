package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;
import com.edu.less28.hotel.ui.ConsoleUI;

public class BookRoom implements ConsoleCommand {

	@Override
	public String getRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.BOOK_ROOM).append("\n");
		int idRoom = ConsoleUI.userIntInput("enter room id:");
		String residentFirstName = ConsoleUI.userStringInput("enter resident first name:");
		String residentLastName = ConsoleUI.userStringInput("enter resident last name:");
		String residentPhoneNumber = ConsoleUI.userStringInput("enter resident phone number:");
		sb.append(idRoom).append("\n");
		sb.append(residentFirstName).append(" | ");
		sb.append(residentLastName).append(" | ");
		sb.append(residentPhoneNumber);
		String request = sb.toString();
		return request;
	}
	
}
