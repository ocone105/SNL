package hanbang.domain;

public class Answer {
	
	private int answerId;
	private int quesOrReviewId;
	private String writerId;
	private String content;
	private String date;
	private int typeId;
	
	
	public int getQuesOrReviewId() {
		return quesOrReviewId;
	}

	public void setQuesOrReviewId(int quesOrReviewId) {
		this.quesOrReviewId = quesOrReviewId;
	}

	public Answer() {
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", quesOrReviewId=" + quesOrReviewId + ", writerId=" + writerId
				+ ", content=" + content + ", date=" + date + ", typeId=" + typeId + "]";
	}
	
}
