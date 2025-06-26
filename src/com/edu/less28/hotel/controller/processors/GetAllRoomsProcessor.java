package com.edu.less28.hotel.controller.processors;

import java.util.List;

import com.edu.less28.hotel.controller.CommandProcessor;
import com.edu.less28.hotel.controller.HotelControllerException;
import com.edu.less28.hotel.model.Room;
import com.edu.less28.hotel.service.HotelServiceProvider;
import com.edu.less28.hotel.service.HotelService;
import com.edu.less28.hotel.service.HotelServiceException;
import com.edu.less28.hotel.util.RoomParser;

public class GetAllRoomsProcessor implements CommandProcessor {

	private HotelService hotelService;

	public GetAllRoomsProcessor() throws HotelControllerException {
		try {
			this.hotelService = HotelServiceProvider.getHotelService();
		} catch (HotelServiceException e) {
			throw new HotelControllerException(e.getMessage(), e);
		}
	}

	@Override
	public String execute(String request) {
		String response = null;
		List<Room> allRooms = hotelService.getAllRooms();
		if (allRooms.size() == 0) {
			response = "No rooms found for your request";
		} else {
			StringBuilder sb = new StringBuilder();
			for (Room room : allRooms) {
				sb.append(RoomParser.getInstance().parseToSrting(room)).append("\n");
			}
			response = sb.toString();
		}
		return response;
	}

}
