package com.edu.less28.hotel.repository;

public class RoomRepositoryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomRepositoryException() {
		super();
	}

	public RoomRepositoryException(String message, Exception e) {
		super(message, e);
	}

	public RoomRepositoryException(String message) {
		super(message);
	}

	public RoomRepositoryException(Exception e) {
		super(e);
	}

}
