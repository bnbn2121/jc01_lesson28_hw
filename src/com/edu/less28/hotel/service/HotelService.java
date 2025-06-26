package com.edu.less28.hotel.service;

import java.util.List;

import com.edu.less28.hotel.model.Resident;
import com.edu.less28.hotel.model.Room;

public interface HotelService {
	public void addRoom(Room room) throws HotelServiceException;

	public void changeRoom(Room updatedRoom) throws HotelServiceException;

	public void removeRoom(int id) throws HotelServiceException;

	public List<Room> getAllRooms();

	public List<Room> getBookedRooms();

	public List<Room> getFreeRooms();

	public void bookRoom(int idRoom, Resident resident) throws HotelServiceException;

	public void cancelBooking(int idRoom) throws HotelServiceException;
}
