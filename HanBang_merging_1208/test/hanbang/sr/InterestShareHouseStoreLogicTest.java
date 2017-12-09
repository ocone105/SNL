package hanbang.sr;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;
import hanbang.store.InterestShareHouseStore;
import hanbang.store.logic.InterestShareHouseStoreLogic;

public class InterestShareHouseStoreLogicTest {
	
	private InterestShareHouseStore iStore;

	@Before
	public void setUp() {
		iStore = new InterestShareHouseStoreLogic();
	}
	
//	@Test
//	public void testCreate() {
//		InterestShareHouse 	iHouse = new InterestShareHouse();
//		iHouse.setMemberId("sora123");
//		iHouse.setShareHouseId(1);
//		
//		iStore.create(iHouse);
//		
//	}
//
//	@Test
//	public void testRetriveAll() {
//		List<ShareHouse> list = null;
//		
//		list =iStore.retriveAll("sora123");
//		assertEquals(1, list.size() );
//	}

//	@Test
//	public void testDelete() {
//		iStore.delete(1);
//	}
//
//	@Test
//	public void testDeleteByMemberId() {
//		iStore.deleteByMemberId("sora123");
//		
//		
//	}

	@Test
	public void testDeleteInterestShareHouse() {
		Map <String, Object> map =new HashMap<>();
		map.put("memberId", "sora123");
		map.put("shareHouseId", 1);
		
		iStore.deleteInterestShareHouse(map);
	}

}
