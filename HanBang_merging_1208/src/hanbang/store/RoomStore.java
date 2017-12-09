package hanbang.store;

import java.util.List;

import hanbang.domain.Room;

public interface RoomStore {

	int create(Room room);

	List<Room> retrive(int shareHouseId);

	int update(Room room);

	int delete(int roomId);

	int deleteByShareHouse(int shareHouseId);

}
