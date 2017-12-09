package hanbang.domain;

import java.sql.Date;
import java.util.List;

public class ShareHouse {

	private int shareHouseId;
	private String writerId;
	private Date shareHouseDate;
	private String title;
	private String content;
	private int houseId;
	private List<Photo> photos;
	private EssentialInfo essentialInfo;
	private ExtraInfo extraInfo;
	private List<Review> reviews;
	private List<Room> rooms;

	@Override
	public String toString() {
		return "ShareHouse [shareHouseId=" + shareHouseId + ", writerId=" + writerId + ", shareHouseDate="
				+ shareHouseDate + ", title=" + title + ", content=" + content + ", houseId=" + houseId + ", photos="
				+ photos + ", essentialInfo=" + essentialInfo + ", extraInfo=" + extraInfo + ", reviews=" + reviews
				+ ", rooms=" + rooms + "]";
	}

	public ShareHouse() {
	}

	public int getShareHouseId() {
		return shareHouseId;
	}

	public void setShareHouseId(int shareHouseId) {
		this.shareHouseId = shareHouseId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getShareHouseDate() {
		return shareHouseDate;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public void setShareHouseDate(Date shareHouseDate) {
		this.shareHouseDate = shareHouseDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public EssentialInfo getEssentialInfo() {
		return essentialInfo;
	}

	public void setEssentialInfo(EssentialInfo essentialInfo) {
		this.essentialInfo = essentialInfo;
	}

	public ExtraInfo getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(ExtraInfo extraInfo) {
		this.extraInfo = extraInfo;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
