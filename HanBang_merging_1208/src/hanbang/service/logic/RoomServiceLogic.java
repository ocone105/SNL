package hanbang.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.ProvidedGood;
import hanbang.domain.Room;
import hanbang.service.RoomService;
import hanbang.store.ProviededGoodStore;
import hanbang.store.RoomStore;

@Service
public class RoomServiceLogic implements RoomService {

	@Autowired
	private RoomStore store;
	@Autowired
	private ProviededGoodStore prStore;

	@Override
	public boolean register(Room room, List<String> providedGoods) {
		int check;
		check = store.create(room);
		for (int i = 0; i < providedGoods.size(); i++) {
			ProvidedGood providedGood = new ProvidedGood();
			providedGood.setProvidedGood(providedGoods.get(i));
			providedGood.setRoomId(check);
			prStore.create(providedGood);
		}
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Room> find(int shareHouseId) {

		List<Room> rooms = store.retrive(shareHouseId);
		List<ProvidedGood> providedGoods = prStore.retriveAll(rooms.get(0).getRoomId());
		rooms.get(0).setProvidedGoods(providedGoods);
		return rooms;
	}

	@Override
	public boolean modify(Room room, List<String> providedGoods) {
		int check;
		check = store.update(room);
		for (int i = 0; i < providedGoods.size(); i++) {
			ProvidedGood providedGood = new ProvidedGood();
			providedGood.setProvidedGood(providedGoods.get(i));
			providedGood.setRoomId(room.getRoomId());
			prStore.create(providedGood);
		}
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByShareHouse(int shareHouseId) {
		int check;
		check = store.deleteByShareHouse(shareHouseId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

}
