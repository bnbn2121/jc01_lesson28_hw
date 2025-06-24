package com.edu.less28.hotel.ui;

import java.util.HashMap;
import java.util.Map;

import com.edu.less28.hotel.ui.impl.AddRoom;
import com.edu.less28.hotel.ui.impl.BookRoom;
import com.edu.less28.hotel.ui.impl.CancelBooking;
import com.edu.less28.hotel.ui.impl.ChangeRoom;
import com.edu.less28.hotel.ui.impl.GetAllRooms;
import com.edu.less28.hotel.ui.impl.GetBookedRooms;
import com.edu.less28.hotel.ui.impl.GetFreeRooms;
import com.edu.less28.hotel.ui.impl.RemoveRoom;

public class ConsoleCommandProvider {
	private static Map<Integer, ConsoleCommand> consoleCommandMap;
	
	static {
		consoleCommandMap = new HashMap<Integer, ConsoleCommand>();
		consoleCommandMap.put(1, new AddRoom());
		consoleCommandMap.put(2, new ChangeRoom());
		consoleCommandMap.put(3, new RemoveRoom());
		consoleCommandMap.put(4, new GetAllRooms());
		consoleCommandMap.put(5, new GetBookedRooms());
		consoleCommandMap.put(6, new GetFreeRooms());
		consoleCommandMap.put(7, new BookRoom());
		consoleCommandMap.put(8, new CancelBooking());
	}
	
	private ConsoleCommandProvider() {
	}

	public static ConsoleCommand getConsoleCommand(int key) {
		return consoleCommandMap.get(key);
	}
}
