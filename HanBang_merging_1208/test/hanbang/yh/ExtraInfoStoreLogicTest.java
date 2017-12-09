package hanbang.yh;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.ExtraInfo;
import hanbang.store.ExtraInfoStore;
import hanbang.store.logic.ExtraInfoStoreLogic;

public class ExtraInfoStoreLogicTest {

	private ExtraInfoStore extraInfoStore;

	@Before
	public void setUp() {
		extraInfoStore = new ExtraInfoStoreLogic();
	}

	// @Test
	// public void testCreate() {
	// ExtraInfo extraInfo = new ExtraInfo();
	// extraInfo.setShareHouseId(1);
	// extraInfo.setHeatingSystem("중앙난방");
	// extraInfo.setPet("불가");
	// extraInfo.setSmoke("불가");
	// extraInfoStore.create(extraInfo);
	// assertNotNull(extraInfo);
	// }

	// @Test
	// public void testRetrive() {
	// ExtraInfo extraInfo = extraInfoStore.retrive(1);
	// assertEquals(extraInfo.getHeatingSystem(), "중앙난방");
	// }
	//
	// @Test
	// public void testUpdate() {
	// ExtraInfo extraInfo = extraInfoStore.retrive(1);
	// extraInfo.setPet("가능");
	// extraInfo.setHeatingSystem("개별난방");
	// extraInfoStore.update(extraInfo);
	// assertEquals(extraInfo.getSmoke(), "불가");
	// assertEquals(extraInfo.getPet(), "가능");
	// }
	//
	// @Test
	// public void testDeleteByShareHouse() {
	// extraInfoStore.deleteByShareHouse(1);
	//
	// assertNull(extraInfoStore.retrive(1));
	// }

}
