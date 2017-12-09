package hanbang.domain;

public class ProvidedGood {

	private int providedGoodId;
	private int roomId;
	private String providedGood;

	@Override
	public String toString() {
		return "ProvidedGood [providedGoodId=" + providedGoodId + ", roomId=" + roomId + ", providedGood="
				+ providedGood + "]";
	}

	public int getProvidedGoodId() {
		return providedGoodId;
	}

	public void setProvidedGoodId(int providedGoodId) {
		this.providedGoodId = providedGoodId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getProvidedGood() {
		return providedGood;
	}

	public void setProvidedGood(String providedGood) {
		this.providedGood = providedGood;
	}

}
