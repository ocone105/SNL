package hanbang.store.mapper;

import java.util.List;
import java.util.Map;

import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;

public interface InterestShareHouseMapper {
	
	int create(InterestShareHouse interestShareHouse);

	List<ShareHouse> retriveAll(String memberId);

	int delete(int shareHouseId);

	int deleteByMemberId(String memberId);

	int deleteInterestShareHouse(Map<String, Object> map);


}
