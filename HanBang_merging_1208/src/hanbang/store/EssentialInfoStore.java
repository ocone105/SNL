package hanbang.store;

import hanbang.domain.EssentialInfo;

public interface EssentialInfoStore {

	int create(EssentialInfo essentialInfo);

	EssentialInfo retrive(int shareHouseId);

	int update(EssentialInfo essentialInfo);

	int deleteByShareHouse(int shareHouseId);

}
