package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.Question;

public interface QuestionMapper {

	int create(Question question);

	List<Question> retriveByMemberId(String memberId);

	List<Question> retriveByShareHouseId(int shareHouseId);

	Question retrive(int questionId);

	int update(Question question);

	int delete(int questionId);

	int deleteByMemberId(String memberId);

	int deleteByShareHouse(int shareHouseId);

}
