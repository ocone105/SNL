package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.House;

public interface HouseMapper {

	int create(House house);

	House retrive(int houseId);
	
	House retriveMyHouse(int houseId);
	
	List<House> retriveAll();

	List<House> retriveByMemberId(String memberId);

	int update(House house);

	int delete(int houseId);

	int deleteByMemberId(String memberId);

}
