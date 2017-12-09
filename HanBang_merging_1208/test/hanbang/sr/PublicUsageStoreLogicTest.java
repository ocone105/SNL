package hanbang.sr;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.PublicUsage;
import hanbang.store.PublicUsageStore;
import hanbang.store.logic.PublicUsageStoreLogic;

public class PublicUsageStoreLogicTest {

	private PublicUsageStore store;

	@Before
	public void setUp() {
		store = new PublicUsageStoreLogic();
	}

	// @Test
	// public void testCreate() {
	// PublicUsage pub = new PublicUsage();
	// pub.setHouseId(1);
	// pub.setPublicUsage("맥북");
	// store.create(pub);
	// }

	// @Test
	// public void testDeleteByHouseId() {
	// store.deleteByHouseId(1);
	// }

	// @Test
	// public void testDelete() {
	//
	// store.delete(7);
	// }

	// @Test
	// public void testRetriveAll() {
	// List<PublicUsage> list =store.retriveAll(1);
	// assertEquals(2, list.size());
	// }
	// @Test
	// public void testUpdate() {
	//
	// PublicUsage publicUsage = store.retrive(1);
	//
	// publicUsage.setPublicUsage("test입니다.");
	// store.update(publicUsage);
	// List<PublicUsage> list =store.retriveAll(30);
	// int index = 0;
	// for(PublicUsage pu : list) {
	// pu = list.get(index);
	// pu.setPublicUsage("1");
	// store.update(pu);
	// index ++;
	// }

}
