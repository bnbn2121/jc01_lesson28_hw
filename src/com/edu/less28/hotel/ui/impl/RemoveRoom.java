package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.ui.ConsoleCommand;
import com.edu.less28.hotel.ui.ConsoleUI;

public class RemoveRoom implements ConsoleCommand {

	@Override
	public String createRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.REMOVE_ROOM).append("\n");
		int id = ConsoleUI.userIntInput("enter id room to remove:");
		sb.append(id);
		String request = sb.toString();
		return request;
	}
	
}