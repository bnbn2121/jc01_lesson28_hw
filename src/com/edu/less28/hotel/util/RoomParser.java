package com.edu.less28.hotel.util;


import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.model.TypeRoom;

public class RoomParser implements HotelParser {
	private final ResidentParser residentParser;
	private static RoomParser instance;

	private RoomParser() {
		this.residentParser = ResidentParser.getInstance();
	}

	public static RoomParser getInstance() {
		if (instance == null) {
			instance = new RoomParser();
		}
		return instance;
	}

	@Override
	public String parseToSrting(Object hotelObject) {
		Room room = (Room) hotelObject;
		StringBuilder sb = new StringBuilder();
		sb.append("%-3s | %-8s | %-6s | %s".formatted(
				room.getId(), 
				room.getType(),
				room.isBooked()==true ? "booked" : "free",
				residentParser.parseToSrting(room.getResident())
				));
		return sb.toString();
	}

	@Override
	public Room parseFromString(String stringData) {
		String[] roomData = stringData.split("\\|",4);
		Room room = new Room(
				Integer.valueOf(roomData[0].trim()), 
				TypeRoom.valueOf(roomData[1].trim().toUpperCase()), 
				roomData[2].trim().equalsIgnoreCase("booked") ? true : false,
				residentParser.parseFromString(roomData[3].trim())
				);
		return room;
	}

}
