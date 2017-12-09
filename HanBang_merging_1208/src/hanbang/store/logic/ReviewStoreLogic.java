package hanbang.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;


import hanbang.domain.Review;
import hanbang.store.ReviewStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.ReviewMapper;

@Repository
public class ReviewStoreLogic implements ReviewStore{
	
	private SqlSessionFactory factory;
	
	public ReviewStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(Review review) {
		SqlSession session = factory.openSession();
		int check = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.create(review);
			session.commit();
		} finally {
			session.close();
		}
		
		return check;
	}

	@Override
	public List<Review> retriveAll(int shareHouseId) {
		SqlSession session = factory.openSession();
		List<Review> list = null;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.retriveAll(shareHouseId);
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public Review retrive(int retriveId) {
		SqlSession session = factory.openSession();
		Review review = null;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			review = mapper.retrive(retriveId);
		} finally {
			session.close();
		}
		return review;
	}

	@Override
	public int update(Review review) {
		SqlSession session = factory.openSession();
		int check = 0;
		
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.update(review);
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
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
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
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.deleteByMemberId(memberId);
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
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.deleteByReviewId(reviewId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int reviewReport(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			check = mapper.reviewReport(map);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

}
