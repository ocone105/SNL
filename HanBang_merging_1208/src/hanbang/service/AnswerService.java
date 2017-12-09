package hanbang.service;

import java.util.List;

import hanbang.domain.Answer;

public interface AnswerService {
	
	// 문의 답변
	boolean registerQuestion(Answer answer);

	List<Answer> findQuestion(int questionId);
	
	Answer findQuestionAnswerById(int answerId);

	boolean modifyQuestion(Answer answer);

	boolean removeQuestionAnswer(String memberId);

	boolean removeByQuestionId(int questionId);
	
	boolean removeByQuesAnswerId(int answerId);
	
	// 후기 답변
	boolean registerReview(Answer answer);

	List<Answer> findReview(int reviewId);
	
	Answer findReviewAnswerById(int answerId);

	boolean modifyReview(Answer answer);

	boolean removeReviewAnswer(String memberId);

	boolean removeByReviewId(int reviewId);

	boolean removeByAnswerId(int answerId);

}
