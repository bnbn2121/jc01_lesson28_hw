package com.edu.less28.hotel.controller.processors;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.CommandParser;

public class CancelBookingProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public CancelBookingProcessor(HotelService hotelService) {
		this.hotelService = hotelService;
	}

	@Override
	public String execute(String request) {
		String response = null;
		String commandData = CommandParser.getCommandData(request);
		int idRoom = Integer.valueOf(commandData);
		try {
			hotelService.cancelBooking(idRoom);
			response = "Booking room with id = %s successfully canceled".formatted(idRoom);
		} catch (HotelServiceException e) {
			response = e.getMessage();
		}
		return response;
	}
	
}
