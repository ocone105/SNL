package hanbang.store;

import java.util.List;

import hanbang.domain.Paging;
import hanbang.domain.Question;

public interface QuestionStore {

	int create(Question question);

	List<Question> retriveByMemberId(String memberId);

	List<Question> retriveByShareHouseId(int shareHouseId);

	Question retrive(int questionId);

	int update(Question question);

	int delete(int questionId);

	int deleteByMemberId(String memberId);

	int deleteByShareHouse(int shareHouseId);
	
	List<Paging> selectPaging(Paging paging);
	
	int selectTotalPaging();

}
