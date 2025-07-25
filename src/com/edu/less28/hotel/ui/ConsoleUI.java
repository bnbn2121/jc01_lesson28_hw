package com.edu.less28.hotel.ui;

import java.util.Scanner;

import com.edu.less28.hotel.controller.CommandName;
import com.edu.less28.hotel.controller.HotelController;

public class ConsoleUI {
	private HotelController hotelController;
	private static Scanner scanner = new Scanner(System.in);

	public ConsoleUI() {
			this.hotelController = HotelController.getController();
	}

	public static int userIntInput(String message) {
		if (message!=null) {
			System.out.println(message);
		}
		while (true) {
			if (scanner.hasNextInt()) {
				int input = scanner.nextInt();
				scanner.nextLine();
				return input;
			}
			scanner.nextLine();
			System.out.println("Not correct input. Try again");
		}
	}
	
	public static String userStringInput(String message) {
		if (message!=null) {
			System.out.println(message);
		}
		return scanner.nextLine();
	}

	private String getRequest(int idCommand) throws IllegalAccessException {
		try {
		ConsoleCommand command = ConsoleCommandProvider.getConsoleCommand(idCommand);
		String request = command.createRequest();
		return request;
		} catch (NullPointerException e){
			throw new IllegalAccessException("No such command");
		}
	}

	public void start() {
		System.out.println("Booking application menu");
		while (true) {
			showAvaliableCommands();
			int idCommand = userIntInput("Please enter number of command:");
			if (idCommand == 0) {
				System.out.println("Application stopped");
				return;
			}
			String response = null;
			try {
				String request = getRequest(idCommand);
				response = hotelController.doAction(request);
			} catch (Exception e) {
				response = e.getMessage();
			}
			System.out.println(response);
			System.out.println();
		}
	}

	public void showAvaliableCommands() {
		System.out.println("Available commands:");
		for (CommandName commandName : CommandName.values()) {
			System.out.println("%s: %s".formatted(commandName.ordinal() + 1, commandName));
		}
		System.out.println("%s: %s".formatted(0, "EXIT"));
		System.out.println();
	}

}
