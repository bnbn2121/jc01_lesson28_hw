package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;
import com.edu.less28.hotel.ui.ConsoleUI;

public class CancelBooking implements ConsoleCommand {

	@Override
	public String createRequest() {
			StringBuilder sb = new StringBuilder();
			sb.append(CommandName.CANCEL_BOOKING).append("\n");
			int idRoom = ConsoleUI.userIntInput("enter room id:");
			sb.append(idRoom);
			String request = sb.toString();
			return request;
	}
	
}
