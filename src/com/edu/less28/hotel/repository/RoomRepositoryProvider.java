package com.edu.less28.hotel.repository;

import com.edu.less28.hotel.repository.impl.FileRoomRepository;

public class RoomRepositoryProvider {
	private static RoomRepository rooms;

	private RoomRepositoryProvider() {
	}

	public static RoomRepository getRoomRepository() {
		if (rooms == null) {
			rooms = new FileRoomRepository();
		}
		return rooms;
	}

}
