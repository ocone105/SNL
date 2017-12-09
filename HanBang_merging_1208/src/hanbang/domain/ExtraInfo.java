package hanbang.domain;

import java.util.List;

public class ExtraInfo {

	private int extraInfoId;
	private int shareHouseId;
	private String pet;
	private String smoke;

	public ExtraInfo() {
	}

	@Override
	public String toString() {
		return "ExtraInfo [extraInfoId=" + extraInfoId + ", shareHouseId=" + shareHouseId + ", pet=" + pet + ", smoke="
				+ smoke + "]";
	}

	public int getExtraInfoId() {
		return extraInfoId;
	}

	public void setExtraInfoId(int extraInfoId) {
		this.extraInfoId = extraInfoId;
	}

	public int getShareHouseId() {
		return shareHouseId;
	}

	public void setShareHouseId(int shareHouseId) {
		this.shareHouseId = shareHouseId;
	}

	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getPet() {
		return pet;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getSmoke() {
		return smoke;
	}

}
