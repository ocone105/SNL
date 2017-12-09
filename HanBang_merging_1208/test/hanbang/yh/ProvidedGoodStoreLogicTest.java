package hanbang.yh;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.ProvidedGood;
import hanbang.store.ProviededGoodStore;
import hanbang.store.logic.ProvidedGoodStoreLogic;

public class ProvidedGoodStoreLogicTest {

	private ProviededGoodStore store;

	@Before
	public void setUp() {
		store = new ProvidedGoodStoreLogic();
	}

	// @Test
	// public void testCreate() {
	// ProvidedGood pG = new ProvidedGood();
	// pG.setExtraInfoId(500);
	// pG.setProvidedGood("www");
	//
	// store.create(pG);
	// assertNotNull(pG);
	// assertEquals("www", store.retriveAll(500).get(0).getProvidedGood());
	// }
	//
	// @Test
	// public void testUpdate() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDelete() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testDeleteByExtraInfo() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testRetriveAll() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testRetrive() {
	// fail("Not yet implemented");
	// }

}
