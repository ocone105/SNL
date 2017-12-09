package hanbang.service;

import java.util.List;

import hanbang.domain.EssentialInfo;
import hanbang.domain.PublicUsage;

public interface EssentialInfoService {

	boolean register(EssentialInfo essentialInfo, List<String> publicUsages);

	EssentialInfo find(int shareHouseId);

	boolean modify(EssentialInfo essentialInfo, List<String> publicUsages);

	boolean deleteByShareHouse(int shareHouseId);

}
