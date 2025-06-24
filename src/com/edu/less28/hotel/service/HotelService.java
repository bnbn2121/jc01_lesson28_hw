package com.edu.less28.hotel.service;

import java.util.List;

import com.edu.less28.hotel.model.Resident;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.repository.RoomRepository;
import com.edu.less28.hotel.repository.RoomRepositoryException;
import com.edu.less28.hotel.repository.RoomRepositoryProvider;

public class HotelService {
	private static HotelService hotelService;
	private RoomRepository rooms;

	public HotelService() throws HotelServiceException {
		try {
			this.rooms = RoomRepositoryProvider.getRoomRepository();
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}
	
	public static HotelService getService() throws HotelServiceException {
		if (hotelService==null) {
			hotelService = new HotelService();
		}
		return hotelService;
	}

	public void addRoom(Room room) throws HotelServiceException {
		if (rooms.isExists(room)) {
			throw new HotelServiceException("Such room number already exists: id = %s".formatted(room.getId()));
		}
		try {
			rooms.addRoom(room);
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}

	public void changeRoom(Room updatedRoom) throws HotelServiceException {
		if (!rooms.isExists(updatedRoom)) {
			throw new HotelServiceException("Such room number doesn't exist: id = %s".formatted(updatedRoom.getId()));
		}
		try {
			rooms.updateRoom(updatedRoom);
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}

	public void removeRoom(int id) throws HotelServiceException {
		if (rooms.findRoomById(id).isEmpty()) {
			throw new HotelServiceException("Such room number doesn't exist: id = %s".formatted(id));
		}
		try {
			rooms.removeRoomById(id);
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}

	public List<Room> getAllRooms() {
		return rooms.getAllRooms();
	}

	public List<Room> getBookedRooms() {
		List<Room> bookedRooms = rooms.getAllRooms().stream()
				.filter(t -> t.isBooked() == true)
				.toList();
		return bookedRooms;

	}

	public List<Room> getFreeRooms() {
		List<Room> freeRooms = rooms.getAllRooms().stream()
				.filter(t -> t.isBooked() == false)
				.toList();
		return freeRooms;

	}

	public void bookRoom(int idRoom, Resident resident) throws HotelServiceException {
		Room room = rooms.findRoomById(idRoom).orElseThrow(()-> new HotelServiceException("Such room number doesn't exist: id = %s".formatted(idRoom)));
		if (room.isBooked()==true) {
			throw new HotelServiceException("Room is already booked");
		}
		room.bookRoom(resident);
		try {
			rooms.updateRoom(room);
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}

	public void cancelBooking(int idRoom) throws HotelServiceException {
		Room room = rooms.findRoomById(idRoom).orElseThrow(()-> new HotelServiceException("Such room number doesn't exist: id = %s".formatted(idRoom)));
		if (room.isBooked()==false) {
			throw new HotelServiceException("Room isn't booked");
		}
		room.cancelBooking();
		try {
			rooms.updateRoom(room);
		} catch (RoomRepositoryException e) {
			throw new HotelServiceException(e);
		}
	}
}
