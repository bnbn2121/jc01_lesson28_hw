package com.edu.less28.hotel.model;

public class Room {
	private final int id;
	private final TypeRoom type;
	private boolean isBooked;
	private Resident resident;

	public Room(int id, TypeRoom type, boolean isBooked, Resident resident) {
		this.id = id;
		this.type = type;
		this.isBooked = isBooked;
		this.resident = resident;
	}

	public Room(int id, TypeRoom type) {
		this.id = id;
		this.type = type;
		this.isBooked = false;
		this.resident = null;
	}



	public int getId() {
		return id;
	}

	public TypeRoom getType() {
		return type;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
	
	public void bookRoom(Resident resident) {
		isBooked = true;
		this.resident=resident;
	}
	
	public void cancelBooking() {
		isBooked = false;
		this.resident=null;
	}

}
