package hanbang.store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.Photo;
import hanbang.store.PhotoStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.PhotoMapper;
import hanbang.store.mapper.ShareHouseMapper;

@Repository
public class PhotoStoreLogic implements PhotoStore {

	private SqlSessionFactory factory;

	public PhotoStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(String photo, int shareHouseId) {

		SqlSession session = factory.openSession();
		int check = 0;

		Map<String, Object> map = new HashMap<>();
		map.put("photo", photo);
		map.put("shareHouseId", shareHouseId);

		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			check = mapper.create(map);
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
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int delete(int photoId) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			check = mapper.delete(photoId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<Photo> retriveAll(int shareHouseId) {
		SqlSession session = factory.openSession();
		List<Photo> photos = null;
		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			photos = mapper.retriveAll(shareHouseId);
		} finally {
			session.close();
		}
		return photos;
	}

	@Override
	public Photo retrive(int photoId) {
		SqlSession session = factory.openSession();
		Photo photo = null;
		try {
			PhotoMapper mapper = session.getMapper(PhotoMapper.class);
			photo = mapper.retrive(photoId);
		} finally {
			session.close();
		}
		return photo;
	}

}
