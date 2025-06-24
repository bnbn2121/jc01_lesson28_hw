package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;

public class GetAllRooms implements ConsoleCommand {

	@Override
	public String getRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.GET_ALL_ROOMS);
		String request = sb.toString();
		return request;
	}
	
}
