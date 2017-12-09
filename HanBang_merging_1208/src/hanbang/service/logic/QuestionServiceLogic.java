package hanbang.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.Answer;
import hanbang.domain.Paging;
import hanbang.domain.Question;
import hanbang.service.QuestionService;
import hanbang.store.QuestionAnswerStore;
import hanbang.store.QuestionStore;

@Service
public class QuestionServiceLogic implements QuestionService{
	
	@Autowired
	private QuestionStore qStore;
	@Autowired
	private QuestionAnswerStore aStore;
	
//	public QuestionServiceLogic() {
//		qStore = new QuestionStoreLogic();
//		aStore = new QuestionAnswerStoreLogic();
//	}

	@Override
	public boolean register(Question question) {
		int check = qStore.create(question);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Question find(int questionId) {
		Question question = qStore.retrive(questionId);
		List<Answer> questionAnswer = aStore.retrieveAll(questionId);
		question.setAnswers(questionAnswer);
		return question;
	}

	@Override
	public List<Question> findByMemberId(String memberId) {
		return qStore.retriveByMemberId(memberId);
	}

	@Override
	public List<Question> findByShareHouseId(int shareHouseId) {
		return qStore.retriveByShareHouseId(shareHouseId);
	}

	@Override
	public boolean modify(Question question) {
		int check = qStore.update(question);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean remove(int questionID) {
		int check = qStore.delete(questionID);
		if(check == 0) {
			return false;
		} else {
			int answerCheck = aStore.deleteByQuestionId(questionID);
			if(answerCheck > 1) {
				return true;
			} else {
				aStore.deleteByQuestionId(questionID);
				return true;
			}
		}
	}

	@Override
	public boolean removeByShareHouse(int shareHouseId) {
		int check = qStore.deleteByShareHouse(shareHouseId);
		if( check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Paging> paging(Paging paging) {
		return qStore.selectPaging(paging);
	}

	@Override
	public int totalPaging() {
		return qStore.selectTotalPaging();
	}

}
