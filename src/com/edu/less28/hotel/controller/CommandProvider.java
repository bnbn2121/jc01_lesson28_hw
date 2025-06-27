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
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceProvider;
import com.edu.less28.hotel.util.CommandParser;

public class CommandProvider {
	private final Map<CommandName, CommandProcessor> commandMap;
	private final HotelService hotelService = HotelServiceProvider.getHotelService();
	
	public CommandProvider() {
		commandMap = new HashMap<CommandName, CommandProcessor>();
		commandMap.put(CommandName.ADD_ROOM, new AddRoomProcessor(hotelService));
		commandMap.put(CommandName.CHANGE_ROOM, new ChangeRoomProcessor(hotelService));
		commandMap.put(CommandName.REMOVE_ROOM, new RemoveRoomProcessor(hotelService));
		commandMap.put(CommandName.BOOK_ROOM, new BookRoomProcessor(hotelService));
		commandMap.put(CommandName.CANCEL_BOOKING, new CancelBookingProcessor(hotelService));
		commandMap.put(CommandName.GET_ALL_ROOMS, new GetAllRoomsProcessor(hotelService));
		commandMap.put(CommandName.GET_BOOKED_ROOMS, new GetBookedRoomsProcessor(hotelService));
		commandMap.put(CommandName.GET_FREE_ROOMS, new GetFreeRoomsProcessor(hotelService));
	}
	
	public CommandProcessor getCommandProcessor(String request) {
		CommandName commandName = CommandName.valueOf(CommandParser.getCommandName(request).toUpperCase());
		CommandProcessor processor = commandMap.get(commandName);
		return processor;
		
	}
}
