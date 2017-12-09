package hanbang.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.ExtraInfo;
import hanbang.service.ExtraInfoService;
import hanbang.store.ExtraInfoStore;

@Service
public class ExtraInfoServiceLogic implements ExtraInfoService {

	@Autowired
	private ExtraInfoStore extraInfoStore;

	@Override
	public boolean register(ExtraInfo extraInfo) {
		int check = extraInfoStore.create(extraInfo);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ExtraInfo find(int shareHouseId) {
		ExtraInfo extraInfo = extraInfoStore.retrive(shareHouseId);

		int extraId = extraInfo.getExtraInfoId();

		return extraInfo;
	}

	@Override
	public boolean modify(ExtraInfo extraInfo) {

		int check = extraInfoStore.update(extraInfo);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByShareHouse(int shareHouseId) {
		int check = extraInfoStore.deleteByShareHouse(shareHouseId);

		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

}
