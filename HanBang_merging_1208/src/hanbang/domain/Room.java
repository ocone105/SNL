package hanbang.domain;

import java.util.List;

public class Room {

	private int roomId;
	private int shareHouseId;
	private String sex;
	private String roomArea;
	private String bathroom;
	private List<ProvidedGood> providedGoods;
	private int deposit;
	private int monthlyFee;
	private String availability;

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", shareHouseId=" + shareHouseId + ", sex=" + sex + ", roomArea=" + roomArea
				+ ", bathroom=" + bathroom + ", providedGoods=" + providedGoods + ", deposit=" + deposit
				+ ", monthlyFee=" + monthlyFee + ", availability=" + availability + "]";
	}

	public Room() {
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getShareHouseId() {
		return shareHouseId;
	}

	public void setShareHouseId(int shareHouseId) {
		this.shareHouseId = shareHouseId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRoomArea() {
		return roomArea;
	}

	public void setRoomArea(String roomArea) {
		this.roomArea = roomArea;
	}

	public String getBathroom() {
		return bathroom;
	}

	public void setBathroom(String bathroom) {
		this.bathroom = bathroom;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public List<ProvidedGood> getProvidedGoods() {
		return providedGoods;
	}

	public void setProvidedGoods(List<ProvidedGood> providedGoods) {
		this.providedGoods = providedGoods;
	}
}
