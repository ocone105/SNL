package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.Answer;
import hanbang.store.QuestionAnswerStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.QuestionAnswerMapper;

@Repository
public class QuestionAnswerStoreLogic implements QuestionAnswerStore {

	private SqlSessionFactory factory;

	public QuestionAnswerStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(Answer answer) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			check = mapper.create(answer);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int update(Answer answer) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			check = mapper.update(answer);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int delete(String memberId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			check = mapper.delete(memberId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByQuestionId(int questionId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			check = mapper.deleteByQuestionId(questionId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByAnswerId(int answerId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			check = mapper.deleteByAnswerId(answerId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<Answer> retrieveAll(int questionId) {
		SqlSession session = factory.openSession();
		List<Answer> list = null;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			list = mapper.retrieveAll(questionId);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Answer retrieveByAnswerId(int answerId) {
		SqlSession session = factory.openSession();
		Answer answer = null;
		try {
			QuestionAnswerMapper mapper = session.getMapper(QuestionAnswerMapper.class);
			answer = mapper.retrieveByAnswerId(answerId);
		} finally {
			session.close();
		}
		return answer;
	}

}
