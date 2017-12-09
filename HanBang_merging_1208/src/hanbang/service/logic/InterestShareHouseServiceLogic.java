package hanbang.service.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.House;
import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;
import hanbang.service.InterestShareHouseService;
import hanbang.store.EssentialInfoStore;
import hanbang.store.HouseStore;
import hanbang.store.InterestShareHouseStore;
import hanbang.store.RoomStore;

@Service
public class InterestShareHouseServiceLogic implements InterestShareHouseService {

	@Autowired
	private InterestShareHouseStore interestHouse;
	@Autowired
	private RoomStore roomStore;
	@Autowired
	private HouseStore houseStore;
	@Autowired
	private EssentialInfoStore essentialInfoStore;
	
	
	@Override
	public boolean register(InterestShareHouse interestShareHouse) {
		int check = interestHouse.create(interestShareHouse);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ShareHouse> findAll(String memberId) {
		List<ShareHouse> list = interestHouse.retriveAll(memberId);
		
		for(ShareHouse ss : list) {
			ss.setRooms(roomStore.retrive(ss.getShareHouseId()));
			ss.setEssentialInfo(essentialInfoStore.retrive(ss.getShareHouseId()));
		}
		return list;
	}

	@Override
	public boolean remove(int shareHouseId) {
		int check = interestHouse.delete(shareHouseId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeByMemberId(String memberId) {
		int check = interestHouse.deleteByMemberId(memberId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeInterestShareHouse(String memberId, int shareHouseId) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		map.put("shareHouseId", shareHouseId);
		int check = interestHouse.deleteInterestShareHouse(map);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}
}
