package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.Paging;
import hanbang.domain.Question;
import hanbang.store.QuestionStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.QuestionMapper;

@Repository
public class QuestionStoreLogic implements QuestionStore {

	private SqlSessionFactory factory;

	public QuestionStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(Question question) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			check = mapper.create(question);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public List<Question> retriveByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		List<Question> list = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.retriveByMemberId(memberId);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Question> retriveByShareHouseId(int shareHouseId) {
		SqlSession session = factory.openSession();
		List<Question> list = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.retriveByShareHouseId(shareHouseId);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Question retrive(int questionId) {
		SqlSession session = factory.openSession();
		Question question = null;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			question = mapper.retrive(questionId);
		} finally {
			session.close();
		}

		return question;
	}

	@Override
	public int update(Question question) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			check = mapper.update(question);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int delete(int questionId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			check = mapper.delete(questionId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int deleteByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			check = mapper.deleteByMemberId(memberId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int deleteByShareHouse(int shareHouseId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public List<Paging> selectPaging(Paging paging) {
		SqlSession session = factory.openSession();
		List<Paging> list = null;
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.selectPaging(paging);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int selectTotalPaging() {
		SqlSession session = factory.openSession();
		int totalPages = 0;
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			totalPages = mapper.selectTotalPaging();
		} finally {
			session.close();
		}
		return totalPages;
	}

}
