package com.edu.less28.hotel.service;

public class HotelServiceProvider {
	private static HotelService hotelService;
	
	private HotelServiceProvider() {
	}
	
	public static HotelService getHotelService() throws HotelServiceException {
		if(hotelService==null) {
			hotelService = new HotelServiceImpl();
		}
		return hotelService;
	}

}
