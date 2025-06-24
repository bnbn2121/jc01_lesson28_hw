package com.edu.less28.hotel.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import com.edu.less28.hotel.model.Room;

public class HotelDataWriter {
	private final RoomParser roomParser = RoomParser.getInstance();
	
	public void writeToFile(Room room, String path) throws IOException {
		try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)))) {
			bWriter.write(roomParser.parseToSrting(room));
		}
	}

	public void writeToFile(List<Room> rooms, String path) throws IOException {
		try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
			for (Room room : rooms) {
				bWriter.write(roomParser.parseToSrting(room));
				bWriter.newLine();
			}
		}
	}
}
