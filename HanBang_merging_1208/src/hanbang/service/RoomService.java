package hanbang.service;

import java.util.List;

import hanbang.domain.ProvidedGood;
import hanbang.domain.Room;

public interface RoomService {

	boolean register(Room room, List<String> providedGoods);

	List<Room> find(int shareHouseId);

	boolean modify(Room room, List<String> providedGoods);

	boolean deleteByShareHouse(int shareHouseId);

}
