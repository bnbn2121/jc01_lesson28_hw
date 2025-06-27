package com.edu.less28.hotel.controller.processors;

import java.util.List;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.util.RoomParser;

public class GetBookedRoomsProcessor implements CommandProcessor{
	
	private HotelService hotelService;

	public GetBookedRoomsProcessor(HotelService hotelService)  {
		this.hotelService = hotelService;
	}

	@Override
	public String execute(String request) {
		String response = null;
		List<Room> bookedRooms = hotelService.getBookedRooms();
		if (bookedRooms.size() == 0) {
			response = "No rooms found for your request";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Room room : bookedRooms) {
				sb.append(RoomParser.getInstance().parseToSrting(room)).append("\n");
			}
			response = sb.toString();
		}
		return response;
	}
	
}
