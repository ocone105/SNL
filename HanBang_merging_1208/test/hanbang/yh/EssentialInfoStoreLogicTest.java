package hanbang.yh;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.EssentialInfo;
import hanbang.store.EssentialInfoStore;
import hanbang.store.logic.EssentialInfoStoreLogic;

public class EssentialInfoStoreLogicTest {

	private EssentialInfoStore essentialInfoStore;

	@Before
	public void setUp() {
		essentialInfoStore = new EssentialInfoStoreLogic();
	}

	// @Test
	// public void testCreate() {
	// EssentialInfo essentialInfo = new EssentialInfo();
	// essentialInfo.setBuildingType("아파트");
	// essentialInfo.setFloorTotalFloor("2층/10층");
	// essentialInfo.setLift("유");
	// essentialInfo.setManagementFee(100000);
	// essentialInfo.setParking("주차 가능");
	// essentialInfo.setSex("남성전용");
	// essentialInfo.setShareHouseId(1);
	//
	// essentialInfoStore.create(essentialInfo);
	// assertNotNull(essentialInfo);
	//
	// }

	// @Test
	// public void testRetrive() {
	// EssentialInfo essentialInfo = essentialInfoStore.retrive(1);
	// assertEquals(essentialInfo.getBuildingType(), "아파트");
	//
	// }

	// @Test
	// public void testUpdate() {
	// EssentialInfo essentialInfo = essentialInfoStore.retrive(1);
	// essentialInfo.setFloorTotalFloor("10층/24층");
	// essentialInfo.setLift("무");
	// essentialInfo.setManagementFee(100000);
	// essentialInfo.setParking("주차 가능, 월1만원");
	// essentialInfoStore.update(essentialInfo);
	// assertEquals(essentialInfo.getBuildingType(), "아파트");
	// assertEquals(essentialInfo.getLift(), "무");
	// }

	// @Test
	// public void testDeleteByShareHouse() {
	//
	// essentialInfoStore.deleteByShareHouse(1);
	// assertNull(essentialInfoStore.retrive(1));
	//
	// }

}
