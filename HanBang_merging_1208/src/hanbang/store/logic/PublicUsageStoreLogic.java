package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.PublicUsage;
import hanbang.store.PublicUsageStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.PublicUsageMapper;

@Repository
public class PublicUsageStoreLogic implements PublicUsageStore {

	private SqlSessionFactory factory;

	public PublicUsageStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(PublicUsage publicUsage) {
		SqlSession session = factory.openSession();
		int check;
		try {
			PublicUsageMapper mapper = session.getMapper(PublicUsageMapper.class);
			check = mapper.create(publicUsage);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByEssentialInfo(int essentialInfoId) {
		SqlSession session = factory.openSession();
		int check;
		try {
			PublicUsageMapper mapper = session.getMapper(PublicUsageMapper.class);
			check = mapper.deleteByEssentialInfo(essentialInfoId);
			session.commit();
		} finally {
			session.close();

		}
		return check;
	}

	@Override
	public int delete(int publicUsageId) {
		SqlSession session = factory.openSession();
		int check;
		try {
			PublicUsageMapper mapper = session.getMapper(PublicUsageMapper.class);
			check = mapper.delete(publicUsageId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<PublicUsage> retriveAll(int essentialInfoId) {
		SqlSession session = factory.openSession();
		List<PublicUsage> list = null;
		try {
			PublicUsageMapper mapper = session.getMapper(PublicUsageMapper.class);
			list = mapper.retriveAll(essentialInfoId);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public PublicUsage retrive(int publicUseageId) {
		SqlSession session = factory.openSession();
		PublicUsage publicUsage;
		try {
			PublicUsageMapper mapper = session.getMapper(PublicUsageMapper.class);
			publicUsage = mapper.retrive(publicUseageId);
		} finally {
			session.close();
		}
		return publicUsage;
	}

}
