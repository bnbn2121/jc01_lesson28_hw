package com.edu.less28.hotel.ui.impl;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.model.TypeRoom;
import com.edu.less28.hotel.ui.ConsoleCommand;
import com.edu.less28.hotel.ui.ConsoleUI;

public class AddRoom implements ConsoleCommand {

	@Override
	public String createRequest() {
		StringBuilder sb = new StringBuilder();
		sb.append(CommandName.ADD_ROOM).append("\n");
		int id = ConsoleUI.userIntInput("enter new room Id:");
		String type = ConsoleUI.userStringInput("enter type (STANDART, COMFORT, LUX) of room:").toUpperCase();
		try {
			TypeRoom typeRoom = TypeRoom.valueOf(type);
			sb.append(id).append(" | ");
			sb.append(typeRoom).append(" | ");
			sb.append("free").append(" | ");
			sb.append("no resident");
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("not correct type of room", e);
		}
		String request = sb.toString();
		return request;
	}

}
