package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;

public class GetFreeRooms implements ConsoleCommand {

	@Override
	public String createRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.GET_FREE_ROOMS);
		String request = sb.toString();
		return request;
	}
	
}