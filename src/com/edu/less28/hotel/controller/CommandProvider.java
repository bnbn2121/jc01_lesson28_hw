package com.edu.less28.hotel.controller;

import java.util.HashMap;
import java.util.Map;

import com.edu.less28.hotel.controller.processors.AddRoomProcessor;
import com.edu.less28.hotel.controller.processors.BookRoomProcessor;
import com.edu.less28.hotel.controller.processors.CancelBookingProcessor;
import com.edu.less28.hotel.controller.processors.ChangeRoomProcessor;
import com.edu.less28.hotel.controller.processors.GetAllRoomsProcessor;
import com.edu.less28.hotel.controller.processors.GetBookedRoomsProcessor;
import com.edu.less28.hotel.controller.processors.GetFreeRoomsProcessor;
import com.edu.less28.hotel.controller.processors.RemoveRoomProcessor;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;

public class CommandProvider {
	private final Map<CommandName, CommandProcessor> commandMap;
	
	public CommandProvider() throws HotelServiceException {
		commandMap = new HashMap<CommandName, CommandProcessor>();
		commandMap.put(CommandName.ADD_ROOM, new AddRoomProcessor());
		commandMap.put(CommandName.CHANGE_ROOM, new ChangeRoomProcessor());
		commandMap.put(CommandName.REMOVE_ROOM, new RemoveRoomProcessor());
		commandMap.put(CommandName.BOOK_ROOM, new BookRoomProcessor());
		commandMap.put(CommandName.CANCEL_BOOKING, new CancelBookingProcessor());
		commandMap.put(CommandName.GET_ALL_ROOMS, new GetAllRoomsProcessor());
		commandMap.put(CommandName.GET_BOOKED_ROOMS, new GetBookedRoomsProcessor());
		commandMap.put(CommandName.GET_FREE_ROOMS, new GetFreeRoomsProcessor());
	}
	
	public CommandProcessor getCommandProcessor(String request) {
		CommandName commandName = CommandName.valueOf(CommandParser.getCommandName(request).toUpperCase());
		CommandProcessor processor = commandMap.get(commandName);
		return processor;
		
	}
}
