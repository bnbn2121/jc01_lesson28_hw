package com.edu.less28.hotel.repository;

import java.util.List;
import java.util.Optional;

import com.edu.less28.hotel.model.Room;


public interface RoomRepository {
	boolean isExists(Room room);
	void addRoom(Room room) throws RoomRepositoryException;
	void updateRoom(Room room) throws RoomRepositoryException;
	Optional<Room> findRoomById(int id);
	void removeRoomById(int id) throws RoomRepositoryException;
	List<Room> getAllRooms();
	
}
