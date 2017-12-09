package hanbang.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.ExtraInfo;
import hanbang.store.ExtraInfoStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.ExtraInfoMapper;

@Repository
public class ExtraInfoStoreLogic implements ExtraInfoStore {

	private SqlSessionFactory factory;

	public ExtraInfoStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(ExtraInfo extraInfo) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ExtraInfoMapper mapper = session.getMapper(ExtraInfoMapper.class);
			check = mapper.create(extraInfo);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public ExtraInfo retrive(int shareHouseId) {
		SqlSession session = factory.openSession();
		ExtraInfo extraInfo = null;

		try {
			ExtraInfoMapper mapper = session.getMapper(ExtraInfoMapper.class);
			extraInfo = mapper.retrive(shareHouseId);
		} finally {
			session.close();
		}

		return extraInfo;
	}

	@Override
	public int update(ExtraInfo extraInfo) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ExtraInfoMapper mapper = session.getMapper(ExtraInfoMapper.class);
			check = mapper.update(extraInfo);
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
			ExtraInfoMapper mapper = session.getMapper(ExtraInfoMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

}
