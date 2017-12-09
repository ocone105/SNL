package hanbang.store;

import hanbang.domain.ExtraInfo;

public interface ExtraInfoStore {

	int create(ExtraInfo extraInfo);

	ExtraInfo retrive(int shareHouseId);

	int update(ExtraInfo extraInfo);

	int deleteByShareHouse(int shareHouseId);
}
