package com.edu.less28.hotel.controller.processors;

import java.util.List;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.RoomParser;

public class GetFreeRoomsProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public GetFreeRoomsProcessor() throws HotelServiceException {
		this.hotelService = HotelService.getService();
	}

	@Override
	public String execute(String request) {
		String response = null;
		List<Room> freeRooms = hotelService.getFreeRooms();
		if (freeRooms.size() == 0) {
			response = "No rooms found for your request";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Room room : freeRooms) {
				sb.append(RoomParser.getInstance().parseToSrting(room)).append("\n");
			}
			response = sb.toString();
		}
		return response;
	}
	
}
