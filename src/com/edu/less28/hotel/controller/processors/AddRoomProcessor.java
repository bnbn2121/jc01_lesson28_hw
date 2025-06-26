package com.edu.less28.hotel.controller.processors;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.controller.HotelControllerException;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.service.HotelServiceProvider;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;
import com.edu.less28.hotel.util.RoomParser;

public class AddRoomProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public AddRoomProcessor() throws HotelControllerException {
		try {
			this.hotelService = HotelServiceProvider.getHotelService();
		} catch (HotelServiceException e) {
			throw new HotelControllerException(e.getMessage(), e);
		}
	}

	@Override
	public String execute(String request) {
		String response = null;
		String commandData = CommandParser.getCommandData(request);
		Room room = RoomParser.getInstance().parseFromString(commandData);
		try {
			hotelService.addRoom(room);
			response = "Room with id = %s successfully added".formatted(room.getId());
		} catch (HotelServiceException e) {
			response = e.getMessage();
		}
		return response;
	}
	
}
