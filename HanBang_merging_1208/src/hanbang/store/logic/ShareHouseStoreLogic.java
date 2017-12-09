package hanbang.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.ShareHouse;
import hanbang.store.ShareHouseStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.ShareHouseMapper;

@Repository
public class ShareHouseStoreLogic implements ShareHouseStore {

	private SqlSessionFactory factory;

	public ShareHouseStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(ShareHouse shareHouse) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			mapper.create(shareHouse);
			session.commit();
			check = shareHouse.getShareHouseId();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public List<ShareHouse> retriveAll() {
		SqlSession session = factory.openSession();
		List<ShareHouse> list = null;
		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			list = mapper.retriveAll();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public ShareHouse retrive(int shareHouseId) {
		SqlSession session = factory.openSession();
		ShareHouse shareHouse = null;
		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			shareHouse = mapper.retrive(shareHouseId);
		} finally {
			session.close();
		}

		return shareHouse;
	}

	@Override
	public int update(ShareHouse shareHouse) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			check = mapper.update(shareHouse);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int delete(int shareHouseId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			check = mapper.delete(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public List<ShareHouse> retriveByMemberId(String writerId) {
		SqlSession session = factory.openSession();
		List<ShareHouse> list = null;
		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			list = mapper.retriveByMemberId(writerId);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<ShareHouse> searchShareHouse(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int report(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			check = mapper.report(map);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public int deleteByMemberId(String writerId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			ShareHouseMapper mapper = session.getMapper(ShareHouseMapper.class);
			check = mapper.deleteByMemberId(writerId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

}
