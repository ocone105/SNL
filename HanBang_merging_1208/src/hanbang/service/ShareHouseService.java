package hanbang.service;

import java.util.List;
import java.util.Map;

import hanbang.domain.EssentialInfo;
import hanbang.domain.ExtraInfo;
import hanbang.domain.Facilitie;
import hanbang.domain.House;
import hanbang.domain.Photo;
import hanbang.domain.ProvidedGood;
import hanbang.domain.Room;
import hanbang.domain.ShareHouse;

public interface ShareHouseService {

	int register(ShareHouse shareHouse);

	List<ShareHouse> findAll();

	ShareHouse find(int shareHouseId);

	List<ShareHouse> findByMemberId(String memberId);

	List<ShareHouse> researchShareHouse(String searchWord);

	boolean modify(ShareHouse shareHouse);

	boolean notify(Map<String, Object> map);

	boolean remove(int shareHouseId);

	boolean removeByMemberId(String memberId);

	boolean savePhoto(String saveFileName, int shareHouseId);

}
