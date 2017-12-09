package hanbang.service;

import java.util.List;

import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;

public interface InterestShareHouseService {
	
	boolean register(InterestShareHouse interestShareHouse);
	List<ShareHouse> findAll(String memberId);
	boolean remove(int shareHouseId);
	boolean removeByMemberId(String memberId);
	boolean removeInterestShareHouse(String memberId, int shareHouseId);

}
