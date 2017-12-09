package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.Answer;
import hanbang.store.ReviewAnswerStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.ReviewAnswerMapper;

@Repository
public class ReviewAnswerStoreLogic implements ReviewAnswerStore{
	
	private SqlSessionFactory factory;
	
	public ReviewAnswerStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(Answer answer) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
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
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
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
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
			check = mapper.delete(memberId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByReviewId(int reviewId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
			check = mapper.deleteByReviewId(reviewId);
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
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
			check = mapper.deleteByAnswerId(answerId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}
	
	@Override
	public List<Answer> retrieveAll(int reviewId) {
		SqlSession session = factory.openSession();
		List<Answer> list = null;
		try {
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
			list = mapper.retrieveAll(reviewId);
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
			ReviewAnswerMapper mapper = session.getMapper(ReviewAnswerMapper.class);
			answer = mapper.retrieveByAnswerId(answerId);
		} finally {
			session.close();
		}
		return answer;
	}

}
