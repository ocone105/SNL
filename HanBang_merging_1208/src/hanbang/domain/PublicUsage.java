package hanbang.domain;

public class PublicUsage {

	private int publicUsageId;
	private int essentialInfoId;
	private String publicUsage;

	@Override
	public String toString() {
		return "PublicUsage [publicUsageId=" + publicUsageId + ", essentialInfoId=" + essentialInfoId + ", publicUsage="
				+ publicUsage + "]";
	}

	public int getPublicUsageId() {
		return publicUsageId;
	}

	public void setPublicUsageId(int publicUsageId) {
		this.publicUsageId = publicUsageId;
	}

	public int getEssentialInfoId() {
		return essentialInfoId;
	}

	public void setEssentialInfoId(int essentialInfoId) {
		this.essentialInfoId = essentialInfoId;
	}

	public String getPublicUsage() {
		return publicUsage;
	}

	public void setPublicUsage(String publicUsage) {
		this.publicUsage = publicUsage;
	}

}
