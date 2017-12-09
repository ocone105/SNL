package hanbang.store;

import java.util.List;
import java.util.Map;

import hanbang.domain.ShareHouse;

public interface ShareHouseStore {

	int create(ShareHouse shareHouse);

	List<ShareHouse> retriveAll();

	ShareHouse retrive(int shareHouseId);

	int update(ShareHouse shareHouse);

	int delete(int shareHouseId);

	List<ShareHouse> retriveByMemberId(String writerId);

	List<ShareHouse> searchShareHouse(String searchWord);

	int report(Map<String, Object> map);

	int deleteByMemberId(String writerId);

}
