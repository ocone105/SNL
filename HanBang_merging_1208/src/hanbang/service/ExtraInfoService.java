package hanbang.service;

import java.util.List;

import hanbang.domain.ExtraInfo;
import hanbang.domain.Facilitie;
import hanbang.domain.ProvidedGood;

public interface ExtraInfoService {

	boolean register(ExtraInfo extraInfo);

	ExtraInfo find(int shareHouseId);

	boolean modify(ExtraInfo extraInfo);

	boolean deleteByShareHouse(int shareHouseId);

}
