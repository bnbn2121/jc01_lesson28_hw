package com.edu.less28.hotel.controller;

public class HotelControllerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelControllerException() {
		super();
	}

	public HotelControllerException(String message, Exception e) {
		super(message, e);
	}

	public HotelControllerException(String message) {
		super(message);
	}

	public HotelControllerException(Exception e) {
		super(e);
	}

}
