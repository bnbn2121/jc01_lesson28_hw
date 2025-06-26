package com.edu.less28.hotel.controller.processors;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.controller.HotelControllerException;
import com.edu.less28.hotel.model.Resident;
import com.edu.less28.hotel.service.HotelServiceProvider;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;
import com.edu.less28.hotel.util.ResidentParser;

public class BookRoomProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public BookRoomProcessor() throws HotelControllerException  {
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
		String[] arrayData = commandData.split("\n");
		int idRoom = Integer.valueOf(arrayData[0].trim());
		Resident resident = ResidentParser.getInstance().parseFromString(arrayData[1]);
		try {
			hotelService.bookRoom(idRoom, resident);;
			response = "Room with id = %s successfully booked".formatted(idRoom);
		} catch (HotelServiceException e) {
			response = e.getMessage();
		}
		return response;
	}
	
}
