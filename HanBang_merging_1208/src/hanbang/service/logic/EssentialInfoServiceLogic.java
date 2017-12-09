package hanbang.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.EssentialInfo;
import hanbang.domain.ProvidedGood;
import hanbang.domain.PublicUsage;
import hanbang.service.EssentialInfoService;
import hanbang.store.EssentialInfoStore;
import hanbang.store.PublicUsageStore;

@Service
public class EssentialInfoServiceLogic implements EssentialInfoService {

	@Autowired
	private EssentialInfoStore essentialStore;
	@Autowired
	private PublicUsageStore publicUsageStore;

	@Override
	public boolean register(EssentialInfo essentialInfo, List<String> publicUsages) {
		int check = essentialStore.create(essentialInfo);
		if (check > 0) {
			for (int i = 0; i < publicUsages.size(); i++) {
				PublicUsage publicUsage = new PublicUsage();
				publicUsage.setPublicUsage(publicUsages.get(i));
				publicUsage.setEssentialInfoId(check);
				publicUsageStore.create(publicUsage);
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public EssentialInfo find(int shareHouseId) {
		EssentialInfo essentialInfo = essentialStore.retrive(shareHouseId);

		int essentialInfoId = essentialInfo.getEssentialInfoId();
		List<PublicUsage> publicUsages = publicUsageStore.retriveAll(essentialInfoId);
		essentialInfo.setPublicUsage(publicUsages);
		
		return essentialInfo;
	}

	@Override
	public boolean modify(EssentialInfo essentialInfo, List<String> publicUsages) {
		int essentialId = essentialInfo.getEssentialInfoId();
		int index = 0;

		EssentialInfo before = essentialStore.retrive(essentialInfo.getShareHouseId());
		publicUsageStore.deleteByEssentialInfo(essentialId);
		for (int i = 0; i < publicUsages.size(); i++) {
			PublicUsage publicUsage = new PublicUsage();
			publicUsage.setPublicUsage(publicUsages.get(i));
			publicUsage.setEssentialInfoId(essentialInfo.getEssentialInfoId());
			publicUsageStore.create(publicUsage);
		}
		int check = essentialStore.update(before);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteByShareHouse(int shareHouseId) {
		int check = essentialStore.deleteByShareHouse(shareHouseId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

}
