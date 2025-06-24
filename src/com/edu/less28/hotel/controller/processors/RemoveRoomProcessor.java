package com.edu.less28.hotel.controller.processors;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;

public class RemoveRoomProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public RemoveRoomProcessor() throws HotelServiceException {
		this.hotelService = HotelService.getService();
	}

	@Override
	public String execute(String request) {
		String response = null;
		String commandData = CommandParser.getCommandData(request);
		int idRoomToRemove = Integer.valueOf(commandData);
		try {
			hotelService.removeRoom(idRoomToRemove);
			response = "Room with id = %s successfully removed".formatted(idRoomToRemove);
		} catch (HotelServiceException e) {
			response = e.getMessage();
		}
		return response;
	}
	
}
