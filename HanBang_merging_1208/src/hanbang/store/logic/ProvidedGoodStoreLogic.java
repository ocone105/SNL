package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.ProvidedGood;
import hanbang.store.ProviededGoodStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.ProvidedGoodMapper;

@Repository
public class ProvidedGoodStoreLogic implements ProviededGoodStore {

	private SqlSessionFactory factory;

	public ProvidedGoodStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(ProvidedGood providedGood) {

		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ProvidedGoodMapper mapper = session.getMapper(ProvidedGoodMapper.class);
			check = mapper.create(providedGood);
			session.commit();
		} finally {
			session.close();
		}
		return check;

	}

	@Override
	public int delete(int providedGoodId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ProvidedGoodMapper mapper = session.getMapper(ProvidedGoodMapper.class);
			check = mapper.delete(providedGoodId);
			session.commit();
		} finally {
			session.close();
		}
		return check;

	}

	@Override
	public int deleteByRoom(int roomId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ProvidedGoodMapper mapper = session.getMapper(ProvidedGoodMapper.class);
			check = mapper.deleteByRoom(roomId);
			session.commit();
		} finally {
			session.close();
		}
		return check;

	}

	@Override
	public List<ProvidedGood> retriveAll(int roomId) {
		SqlSession session = factory.openSession();
		List<ProvidedGood> providedGoods = null;
		try {
			ProvidedGoodMapper mapper = session.getMapper(ProvidedGoodMapper.class);
			providedGoods = mapper.retriveAll(roomId);
		} finally {
			session.close();
		}
		return providedGoods;
	}

	@Override
	public ProvidedGood retrive(int providedGoodId) {
		SqlSession session = factory.openSession();
		ProvidedGood providedGood = null;
		try {
			ProvidedGoodMapper mapper = session.getMapper(ProvidedGoodMapper.class);
			providedGood = mapper.retrive(providedGoodId);
		} finally {
			session.close();
		}
		return providedGood;
	}

}
