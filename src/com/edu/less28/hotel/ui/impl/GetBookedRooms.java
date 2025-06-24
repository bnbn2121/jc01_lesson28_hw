package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;

public class GetBookedRooms implements ConsoleCommand {

	@Override
	public String getRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.GET_BOOKED_ROOMS);
		String request = sb.toString();
		return request;
	}
	
}