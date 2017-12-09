package hanbang.domain;

import java.util.List;

public class Question {
	
	private int questionId;
	private String writerId;
	private int shareHouseId;
	private String questionDate;
	private String schedule;
	private String phoneNumber;
	private String questionContent;
	private List<Answer> answers;

	public Question() {
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}


	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public int getShareHouseId() {
		return shareHouseId;
	}

	public void setShareHouseId(int shareHouseId) {
		this.shareHouseId = shareHouseId;
	}

	public String getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", writerId=" + writerId + ", shareHouseId=" + shareHouseId
				+ ", questionDate=" + questionDate + ", schedule=" + schedule + ", phoneNumber=" + phoneNumber
				+ ", questionContent=" + questionContent + ", answers=" + answers + "]";
	}
	
}
