package com.edu.less28.hotel.service;

public class HotelServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelServiceException() {
		super();
	}

	public HotelServiceException(String message, Exception e) {
		super(message, e);
	}

	public HotelServiceException(String message) {
		super(message);
	}

	public HotelServiceException(Exception e) {
		super(e);
	}

}
