package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.Answer;

public interface ReviewAnswerMapper {
	
	int create(Answer answer);

	List<Answer> retrieveAll(int reviewId);
	
	Answer retrieveByAnswerId(int answerId);

	int update(Answer answer);

	int delete(String memberId);

	int deleteByReviewId(int reviewId);

	int deleteByAnswerId(int answerId);


}
