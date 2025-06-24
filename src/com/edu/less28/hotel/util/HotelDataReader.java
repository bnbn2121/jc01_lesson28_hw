package com.edu.less28.hotel.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.edu.less28.hotel.model.Room;

public class HotelDataReader {
private final RoomParser roomParser = RoomParser.getInstance();
	
	public List<Room> getRooms(String path) throws IOException {
		List<Room> rooms = new ArrayList<Room>();
		try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			String tempString;
			while ((tempString = bReader.readLine()) != null) {
					Room room  = roomParser.parseFromString(tempString);
					rooms.add(room);
			}
		}
		return rooms;
	}
}
