package com.edu.less28.hotel.service;

import com.edu.less28.hotel.service.impl.HotelServiceImpl;

public class HotelServiceProvider {
	private static HotelService hotelService;
	
	private HotelServiceProvider() {
	}
	
	public static HotelService getHotelService() {
		if(hotelService==null) {
			hotelService = new HotelServiceImpl();
		}
		return hotelService;
	}

}
