package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.Room;

public interface RoomMapper {

	int create(Room room);

	List<Room> retrive(int shareHouseId);

	int update(Room room);

	int delete(int roomId);

	int deleteByShareHouse(int shareHouseId);

}
