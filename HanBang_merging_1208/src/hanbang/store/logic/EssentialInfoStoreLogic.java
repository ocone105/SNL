package hanbang.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.EssentialInfo;
import hanbang.store.EssentialInfoStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.EssentialInfoMapper;

@Repository
public class EssentialInfoStoreLogic implements EssentialInfoStore {

	private SqlSessionFactory factory;

	public EssentialInfoStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(EssentialInfo essentialInfo) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			EssentialInfoMapper mapper = session.getMapper(EssentialInfoMapper.class);
			mapper.create(essentialInfo);
			session.commit();
			check = essentialInfo.getEssentialInfoId();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public EssentialInfo retrive(int shareHouseId) {

		SqlSession session = factory.openSession();
		EssentialInfo essentialInfo = null;

		try {
			EssentialInfoMapper mapper = session.getMapper(EssentialInfoMapper.class);
			essentialInfo = mapper.retrive(shareHouseId);
		} finally {
			session.close();
		}

		return essentialInfo;
	}

	@Override
	public int update(EssentialInfo essentialInfo) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			EssentialInfoMapper mapper = session.getMapper(EssentialInfoMapper.class);
			check = mapper.update(essentialInfo);
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
			EssentialInfoMapper mapper = session.getMapper(EssentialInfoMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

}
