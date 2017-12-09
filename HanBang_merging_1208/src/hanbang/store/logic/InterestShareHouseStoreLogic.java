package hanbang.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;
import hanbang.store.InterestShareHouseStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.InterestShareHouseMapper;

@Repository
public class InterestShareHouseStoreLogic implements InterestShareHouseStore {

	private SqlSessionFactory factory;
	
	public InterestShareHouseStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	@Override
	public int create(InterestShareHouse interestShareHouse) {
		SqlSession session = factory.openSession();
		int check;
		try {
			InterestShareHouseMapper mapper = session.getMapper(InterestShareHouseMapper.class);
			check = mapper.create(interestShareHouse);
			session.commit();
		}finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<ShareHouse> retriveAll(String memberId) {
		SqlSession session = factory.openSession();
		List<ShareHouse> shareHouses = null;
		try {
			InterestShareHouseMapper mapper = session.getMapper(InterestShareHouseMapper.class);
			shareHouses = mapper.retriveAll(memberId);
		
		}finally {
			session.close();
		}
		return shareHouses;
	}

	@Override
	public int delete(int shareHouseId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			InterestShareHouseMapper mapper = session.getMapper(InterestShareHouseMapper.class);
			check = mapper.delete(shareHouseId);
			session.commit();
		}finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			InterestShareHouseMapper mapper = session.getMapper(InterestShareHouseMapper.class);
			check = mapper.deleteByMemberId(memberId);
			session.commit();
		}finally {
			session.close();
		}
		return check;
	}

	@Override
	public int deleteInterestShareHouse(Map<String, Object> map) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			InterestShareHouseMapper mapper = session.getMapper(InterestShareHouseMapper.class);
			check= mapper.deleteInterestShareHouse(map);
			session.commit();
		}finally {
			session.close();
		}
		return check;
	}

}
