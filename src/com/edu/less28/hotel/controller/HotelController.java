package com.edu.less28.hotel.controller;

import com.edu.less28.hotel.service.HotelServiceException;

public class HotelController {
	private static HotelController hotelController;
	private static CommandProvider commandProvider;
	
	private HotelController() throws HotelServiceException {
		commandProvider = new CommandProvider();
	}
	
	public static HotelController getController() throws HotelServiceException {
		if (hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public String doAction(String request) {
		CommandProcessor commandProcessor = commandProvider.getCommandProcessor(request);
		String response = commandProcessor.execute(request);
		return response;
	}

}
