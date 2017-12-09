package hanbang.service.logic;

import java.util.List;

import org.springframework.stereotype.Service;

import hanbang.domain.Answer;
import hanbang.service.AnswerService;
import hanbang.store.QuestionAnswerStore;
import hanbang.store.ReviewAnswerStore;
import hanbang.store.logic.QuestionAnswerStoreLogic;
import hanbang.store.logic.ReviewAnswerStoreLogic;

@Service
public class AnswerServiceLogic implements AnswerService{
	
	private QuestionAnswerStore qStore;
	private ReviewAnswerStore rStore;
	
	public AnswerServiceLogic() {
		qStore = new QuestionAnswerStoreLogic();
		rStore = new ReviewAnswerStoreLogic();
	}

	@Override
	public boolean registerQuestion(Answer answer) {
		int check = qStore.create(answer);
//		answer.setTypeId(1);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<Answer> findQuestion(int questionId) {
		return qStore.retrieveAll(questionId);
	}

	@Override
	public boolean modifyQuestion(Answer answer) {
		int check = qStore.update(answer);
		if(check == 0) {
			return false;
		} else {
			 return true;
		}
	}

	@Override
	public boolean removeQuestionAnswer(String memberId) {
		int check = qStore.delete(memberId);
		if(check == 0) {
			return false;
		} else {
			 return true;
		}
	}

	@Override
	public boolean removeByQuestionId(int questionId) {
		int check = qStore.deleteByQuestionId(questionId);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public boolean removeByQuesAnswerId(int answerId) {
		int check = qStore.deleteByAnswerId(answerId);
		if(check==0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public Answer findQuestionAnswerById(int answerId) {
		return qStore.retrieveByAnswerId(answerId);
	}
	
	
	// 후기 답변
	@Override
	public boolean registerReview(Answer answer) {
		int check = 0;
		check = rStore.create(answer);
//		answer.setTypeId(2);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Answer> findReview(int reviewId) {
		return rStore.retrieveAll(reviewId);
	}

	@Override
	public boolean modifyReview(Answer answer) {
		int check = rStore.update(answer);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean removeReviewAnswer(String memberId) {
		int check = rStore.delete(memberId);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean removeByReviewId(int reviewId) {
		int check = rStore.deleteByReviewId(reviewId);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean removeByAnswerId(int answerId) {
		int check = rStore.deleteByAnswerId(answerId);
		if(check == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Answer findReviewAnswerById(int answerId) {
		return rStore.retrieveByAnswerId(answerId);
	}

}
