package hanbang.service;

import java.util.List;

import hanbang.domain.House;
import hanbang.domain.PublicUsage;

public interface HouseService {
	
	boolean register(House house);
	House find(int houseId);
	House findMyHouse(int houseId);
	List<House> findByMemberId(String memberId);
	List<House> findAll();
	boolean modify(House house);
	boolean remove(int houseId);
	boolean removeByMemberId(String memberId);

}
