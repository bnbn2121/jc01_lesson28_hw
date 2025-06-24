package com.edu.less28.hotel.repository;

public class RoomRepositoryProvider {
	private static RoomRepository rooms;

	private RoomRepositoryProvider() {
	}

	public static RoomRepository getRoomRepository() throws RoomRepositoryException {
		if (rooms == null) {
			rooms = new FileRoomRepository();
		}
		return rooms;
	}

}
