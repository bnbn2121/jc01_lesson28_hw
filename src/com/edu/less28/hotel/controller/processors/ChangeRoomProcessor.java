package com.edu.less28.hotel.controller.processors;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;
import com.edu.less28.hotel.util.RoomParser;

public class ChangeRoomProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public ChangeRoomProcessor() throws HotelServiceException {
		this.hotelService = HotelService.getService();
	}

	@Override
	public String execute(String request) {
		String response = null;
		String commandData = CommandParser.getCommandData(request);
		Room room = RoomParser.getInstance().parseFromString(commandData);
		try {
			hotelService.changeRoom(room);
			response = "Room with id = %s successfully changed".formatted(room.getId());
		} catch (HotelServiceException e) {
			response = e.getMessage();
		}
		return response;
	}
	
}
