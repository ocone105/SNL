package hanbang.store.mapper;

import hanbang.domain.ExtraInfo;

public interface ExtraInfoMapper {

	int create(ExtraInfo extraInfo);

	ExtraInfo retrive(int shareHouseId);

	int update(ExtraInfo extraInfo);

	int delete(int extraInfoId);

	int deleteByShareHouse(int shareHouseId);

}
