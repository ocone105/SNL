package hanbang.domain;

import java.util.List;

public class Review {
	
	private int reviewId;
	private String writerId;
	private String date;
	private int shareHouseId;
	private String title;
	private String photo;
	private String content;
	private List<Answer> answers;
	
	
	
	public int getShareHouseId() {
		return shareHouseId;
	}

	public void setShareHouseId(int shareHouseId) {
		this.shareHouseId = shareHouseId;
	}

	public Review() {
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", writerId=" + writerId + ", date=" + date + ", shareHouseId="
				+ shareHouseId + ", title=" + title + ", photo=" + photo + ", content=" + content + ", answers="
				+ answers + "]";
	}
	
}
