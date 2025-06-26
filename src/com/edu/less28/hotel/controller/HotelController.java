package com.edu.less28.hotel.controller;

public class HotelController {
	private static HotelController hotelController;
	private static CommandProvider commandProvider;
	
	private HotelController() throws HotelControllerException {
			commandProvider = new CommandProvider();
	}
	
	public static HotelController getController() throws HotelControllerException  {
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
