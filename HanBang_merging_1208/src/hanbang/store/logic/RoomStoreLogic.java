package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import hanbang.domain.Room;
import hanbang.store.RoomStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.RoomMapper;

@Repository
public class RoomStoreLogic implements RoomStore {

	private SqlSessionFactory factory;

	public RoomStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public int create(Room room) {
		SqlSession session = factory.openSession();
		int check = 0;

		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			mapper.create(room);
			session.commit();
			check = room.getRoomId();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public List<Room> retrive(int shareHouseId) {
		SqlSession session = factory.openSession();
		List<Room> rooms = null;
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			rooms = mapper.retrive(shareHouseId);
		} finally {
			session.close();
		}
		return rooms;
	}

	@Override
	public int update(Room room) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			check = mapper.update(room);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int delete(int roomId) {
		SqlSession session = factory.openSession();
		int check = 0;
		try {
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			check = mapper.delete(roomId);
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
			RoomMapper mapper = session.getMapper(RoomMapper.class);
			check = mapper.deleteByShareHouse(shareHouseId);
			session.commit();
		} finally {
			session.close();
		}
		return check;
	}

}
