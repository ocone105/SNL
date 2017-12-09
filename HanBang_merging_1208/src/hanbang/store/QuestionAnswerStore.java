package hanbang.store;

import java.util.List;

import hanbang.domain.Answer;

public interface QuestionAnswerStore {

	int create(Answer answer);

	List<Answer> retrieveAll(int questionId);
	
	Answer retrieveByAnswerId(int answerId);

	int update(Answer answer);

	int delete(String memberId);

	int deleteByQuestionId(int questionId);

	int deleteByAnswerId(int answerId);

}
