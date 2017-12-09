package hanbang.yh;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.ShareHouse;
import hanbang.store.ShareHouseStore;
import hanbang.store.logic.ShareHouseStoreLogic;

public class ShareHouseStoreLogicTest {

	private ShareHouseStore shareHouseStore;

	@Before
	public void setUp() {
		shareHouseStore = new ShareHouseStoreLogic();
	}

	// @Test
	// public void testCreate() {
	// ShareHouse shareHouse = new ShareHouse();
	// shareHouse.setTitle("noname");
	// shareHouse.setContent("nocontent");
	// shareHouse.setHouseId(4);
	// shareHouse.setWriterId("yh");
	// shareHouseStore.create(shareHouse);
	// assertNotNull(shareHouse);
	// }

	// @Test
	// public void testRetriveAll() {
	// List<ShareHouse> list = new ArrayList<>();
	// list = shareHouseStore.retriveAll();
	// assertEquals(list.size(), 3);
	// assertNotNull(list);
	// }

	// @Test
	// public void testRetrive() {
	// ShareHouse shareHouse = new ShareHouse();
	// shareHouse = shareHouseStore.retrive(1);
	// assertNotNull(shareHouse);
	// }

	// @Test
	// public void testUpdate() {
	// ShareHouse shareHouse = shareHouseStore.retrive(4);
	// shareHouse.setContent("test02");
	// shareHouse.setTitle("home");
	// shareHouseStore.update(shareHouse);
	// assertEquals("home", shareHouse.getTitle());
	// assertEquals("test", shareHouse.getWriterId());
	//
	// }

	// @Test
	// public void testDelete() {
	// shareHouseStore.delete(4);
	// assertNull(shareHouseStore.retrive(4));
	// }

	// @Test
	// public void testRetriveByMemberId() {
	// List<ShareHouse> list = shareHouseStore.retriveByMemberId("yh");
	// assertEquals(list.size(), 2);
	// }
	//
	// @Test
	// public void testSearchShareHouse() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testReport() {
	// fail("Not yet implemented");
	// }

	// @Test
	// public void testDeleteByMemberId() {
	// shareHouseStore.deleteByMemberId("yh");
	// assertNull(shareHouseStore.retriveByMemberId("yh"));
	//
	// }

}
