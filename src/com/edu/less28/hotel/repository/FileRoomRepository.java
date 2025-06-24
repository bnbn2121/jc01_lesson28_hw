package com.edu.less28.hotel.repository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import com.edu.less28.hotel.main.Main;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.util.HotelDataReader;
import com.edu.less28.hotel.util.HotelDataWriter;

public class FileRoomRepository implements RoomRepository {
	private final String DATA_PATH;
	private HotelDataWriter writer;
	private HotelDataReader reader;
	private List<Room> tempRooms;

	public FileRoomRepository() throws RoomRepositoryException {
		URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
		DATA_PATH = location.getPath() + "resources/HotelData.txt";
		writer = new HotelDataWriter();
		reader = new HotelDataReader();
		tempRooms = loadRoomsFromFile();
	}

	private List<Room> loadRoomsFromFile() throws RoomRepositoryException {
		try {
			return reader.getRooms(DATA_PATH);
		} catch (IOException e) {
			throw new RoomRepositoryException("Failed to load rooms from file", e);
		}
	}

	private void saveRoomsToFile() throws RoomRepositoryException {
		try {
			writer.writeToFile(tempRooms, DATA_PATH);
		} catch (IOException e) {
			throw new RoomRepositoryException("Failed to save rooms to file", e);
		}
	}

	// при поиске возвращаем позицию в листе. Если не нашли, то -1.
	private int findRoomIndex(int RoomId) {
		int indexRoomInList = -1;
		for (int i = 0; i < tempRooms.size(); i++) {
			if (RoomId == tempRooms.get(i).getId()) {
				indexRoomInList = i;
				break;
			}
		}
		return indexRoomInList;
	}

	private int findRoomIndex(Room room) {
		int roomId = room.getId();
		return findRoomIndex(roomId);
	}

	@Override
	public boolean isExists(Room room) {
		if(findRoomIndex(room)==-1) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public void addRoom(Room room) throws RoomRepositoryException {
		tempRooms.add(room);
		saveRoomsToFile();
	}

	@Override
	public void updateRoom(Room roomUpdated) throws RoomRepositoryException {
		int indexRoomForUpdate = findRoomIndex(roomUpdated);
		tempRooms.set(indexRoomForUpdate, roomUpdated);
		saveRoomsToFile();
	}

	@Override
	public Optional<Room> findRoomById(int RoomId) {
		int indexRoom = findRoomIndex(RoomId);
		return Optional.ofNullable(tempRooms.get(indexRoom));
	}

	@Override
	public void removeRoomById(int RoomId) throws RoomRepositoryException {
		int indexRoom = findRoomIndex(RoomId);
		tempRooms.remove(indexRoom);
		saveRoomsToFile();
	}

	@Override
	public List<Room> getAllRooms() {
		return tempRooms;
	}

}
