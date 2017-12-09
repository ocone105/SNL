package hanbang.sr;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import hanbang.domain.House;
import hanbang.store.HouseStore;
import hanbang.store.PublicUsageStore;
import hanbang.store.logic.HouseStoreLogic;
import hanbang.store.logic.PublicUsageStoreLogic;

public class HouseStoreLogicTest {
	
	private HouseStore store;
	private PublicUsageStore pStore;
	
	@Before
	public void setUp() {
		store = new HouseStoreLogic();
		pStore = new PublicUsageStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		House house = new House();
//		house.setAddress("강원");
//		house.setBathrooms(1);
//		house.setMemberId("sora123");
//		house.setWholeArea(1);
//		house.setRooms(6);
//		
//		store.create(house);
//	}

//	@Test
//	public void testRetrive() {
//		House house = store.retrive(30);
//		
//		assertEquals("서울", house.getAddress());
//	}

//	@Test
//	public void testRetriveByMemberId() {
//		List<House> houses = store.retriveByMemberId("sora123");
//		
//		assertEquals(5, houses.size());
//	}

//	@Test
//	public void testUpdate() {
//		House house = store.retrive(30);
//		house.setBathrooms(13);
//		
//		store.update(house);
//		
//	}

//	@Test
//	public void testDelete() {
//		store.delete(32);
//	}

//	@Test
//	public void testDeleteByMemberId() {
//		pStore.deleteByHouseId(1);
//		store.deleteByMemberId("ㅇㅇ");
//	}
	
	@Test
	public void testRetriveMyHouse() {
		House house = store.retriveMyHouse(30);
		assertEquals("서울", house.getAddress());
	}

}
