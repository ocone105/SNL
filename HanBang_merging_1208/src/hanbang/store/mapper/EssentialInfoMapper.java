package hanbang.store.mapper;

import hanbang.domain.EssentialInfo;

public interface EssentialInfoMapper {

	int create(EssentialInfo essentialInfo);

	EssentialInfo retrive(int shareHouseId);

	int update(EssentialInfo essentialInfo);

	int delete(int essentialInfoId);

	int deleteByShareHouse(int shareHouseId);

}
