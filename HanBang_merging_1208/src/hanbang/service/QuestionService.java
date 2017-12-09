package hanbang.service;

import java.util.List;

import hanbang.domain.Question;

public interface QuestionService {

	boolean register(Question question);

	Question find(int questionId);

	List<Question> findByMemberId(String memberId);

	List<Question> findByShareHouseId(int shareHouseId);

	boolean modify(Question question);

	boolean remove(int questionID);

	boolean removeByShareHouse(int shareHouseId);

}
