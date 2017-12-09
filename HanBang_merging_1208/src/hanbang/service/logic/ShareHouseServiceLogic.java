package hanbang.service.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.ShareHouse;
import hanbang.service.EssentialInfoService;
import hanbang.service.ExtraInfoService;
import hanbang.service.ShareHouseService;
import hanbang.store.PhotoStore;
import hanbang.store.RoomStore;
import hanbang.store.ShareHouseStore;

@Service
public class ShareHouseServiceLogic implements ShareHouseService {

	@Autowired
	private ShareHouseStore shareHouseStore;
	@Autowired
	private RoomStore roomStore;
	@Autowired
	private EssentialInfoService essentialInfoService;
	@Autowired
	private ExtraInfoService extraInfoService;
	@Autowired
	private PhotoStore photoStore;

	@Override
	public int register(ShareHouse shareHouse) {
		int check = 0;
		check = shareHouseStore.create(shareHouse);
		return check;
	}

	@Override
	public List<ShareHouse> findAll() {

		List<ShareHouse> list = shareHouseStore.retriveAll();
		for (ShareHouse shareHouse : list) {

			shareHouse.setRooms(roomStore.retrive(shareHouse.getShareHouseId()));
			shareHouse.setEssentialInfo(essentialInfoService.find(shareHouse.getShareHouseId()));
			shareHouse.setPhotos(photoStore.retriveAll(shareHouse.getShareHouseId()));

		}

		return list;
	}

	@Override
	public ShareHouse find(int shareHouseId) {

		ShareHouse shareHouse = shareHouseStore.retrive(shareHouseId);
		shareHouse.setRooms(roomStore.retrive(shareHouseId));
		shareHouse.setEssentialInfo(essentialInfoService.find(shareHouseId));
		shareHouse.setExtraInfo(extraInfoService.find(shareHouseId));
		return shareHouse;
	}

	@Override
	public List<ShareHouse> findByMemberId(String memberId) {
		List<ShareHouse> list = new ArrayList<>();
		list = shareHouseStore.retriveByMemberId(memberId);
		for (ShareHouse shareHouse : list) {

			shareHouse.setRooms(roomStore.retrive(shareHouse.getShareHouseId()));
			shareHouse.setEssentialInfo(essentialInfoService.find(shareHouse.getShareHouseId()));

		}
		return list;
	}

	@Override
	public List<ShareHouse> researchShareHouse(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(ShareHouse shareHouse) {

		int check = 0;

		check = shareHouseStore.update(shareHouse);

		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean notify(Map<String, Object> map) {

		int check = 0;

		check = shareHouseStore.report(map);

		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean remove(int shareHouseId) {
		roomStore.deleteByShareHouse(shareHouseId);
		int check = shareHouseStore.delete(shareHouseId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeByMemberId(String memberId) {

		List<ShareHouse> list = new ArrayList<>();
		list = shareHouseStore.retriveByMemberId(memberId);
		int index = 0;
		for (ShareHouse shareHouse : list) {
			shareHouse = new ShareHouse();

			shareHouse = list.get(index);
			int shareHouseId = shareHouse.getShareHouseId();
			roomStore.deleteByShareHouse(shareHouseId);
			essentialInfoService.deleteByShareHouse(shareHouseId);
			extraInfoService.deleteByShareHouse(shareHouseId);
			index++;
		}
		int check = shareHouseStore.deleteByMemberId(memberId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean savePhoto(String saveFileName, int shareHouseId) {
		int check = photoStore.create(saveFileName, shareHouseId);
		if (check > 0) {
			return true;
		} else {
			return false;
		}
	}

}
