package com.edu.less28.hotel.model;

import java.util.Objects;

public class Room {
	private int id;
	private TypeRoom type;
	private boolean isBooked;
	private Resident resident;

	public Room() {
	}

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

	public void setId(int id) {
		if (this.id == 0) {
			this.id = id;
		}
	}

	public int getId() {
		return id;
	}

	public void setType(TypeRoom type) {
		if (this.type == null) {
			this.type = type;
		}
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
		this.resident = resident;
	}

	public void cancelBooking() {
		isBooked = false;
		this.resident = null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isBooked, resident, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return id == other.id && isBooked == other.isBooked && Objects.equals(resident, other.resident)
				&& type == other.type;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", " + (type != null ? "type=" + type + ", " : "") + "isBooked=" + isBooked + ", "
				+ (resident != null ? "resident=" + resident : "") + "]";
	}

}
