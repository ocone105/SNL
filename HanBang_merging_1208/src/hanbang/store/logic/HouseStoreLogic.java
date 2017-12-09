package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.House;
import hanbang.store.HouseStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.HouseMapper;

@Repository
public class HouseStoreLogic implements HouseStore {

	private SqlSessionFactory factory;
	private int check = 0;

	public HouseStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();

	}

	@Override
	public int create(House house) {
		SqlSession session = factory.openSession();
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			check = mapper.create(house);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public House retrive(int houseId) {
		SqlSession session = factory.openSession();
		House house;
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			house = mapper.retrive(houseId);
		} finally {
			session.close();
		}
		return house;
	}

	@Override
	public List<House> retriveByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		List<House> list = null;
		try {

			HouseMapper mapper = session.getMapper(HouseMapper.class);
			list = mapper.retriveByMemberId(memberId);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int update(House house) {
		SqlSession session = factory.openSession();

		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			check = mapper.update(house);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int delete(int houseId) {
		SqlSession session = factory.openSession();
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			check = mapper.delete(houseId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			check = mapper.deleteByMemberId(memberId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public House retriveMyHouse(int houseId) {
		SqlSession session = factory.openSession();
		House house;
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			house = mapper.retriveMyHouse(houseId);
		} finally {
			session.close();
		}
		return house;
	}

	@Override
	public List<House> retriveAll() {
		SqlSession session = factory.openSession();
		List<House> list;
		try {
			HouseMapper mapper = session.getMapper(HouseMapper.class);
			list = mapper.retriveAll();
		} finally {
			session.close();
		}
		return list;
	}

}
