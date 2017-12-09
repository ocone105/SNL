package hanbang.sh;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.Review;
import hanbang.store.ReviewStore;
import hanbang.store.logic.ReviewStoreLogic;

public class ReviewStoreLogicTest {
	
	private ReviewStore store;
	
	@Before
	public void setUp() {
		store = new ReviewStoreLogic();
	}
	
//	@Test
//	public void testCreate() {
//		Review review = new Review();
//		review.setContent("22 test");
//		review.setTitle("11");
//		review.setWriterId("ms");
//		review.setShareHouseId(1);
//		store.create(review);
//		assertNotNull(review);
//	}

//	@Test
//	public void testRetriveAll() {
//		
//	}

//	@Test
//	public void testRetrive() {
//		Review review = store.retrive(6);
//		assertEquals("sh", review.getWriterId());
//	}
//
//	@Test
//	public void testUpdate() {
//		Review review = store.retrive(6);
//		review.setContent("111");
//		store.update(review);
//	}

//	@Test
//	public void testDeleteByShareHouse() {
//		store.deleteByShareHouse(1);
//	}

//	@Test
//	public void testReviewReport() {
//		Map<String, Object> map = new HashMap<>();
//		map.put("reporterId", "sh");
//		map.put("reviewId", 12);
//		store.reviewReport(map);
//	}

//	@Test
//	public void testDeleteByMemberId() {
//		store.deleteByMemberId("ms");
//	}

//	@Test
//	public void testDeleteByReviewId() {
//		store.deleteByReviewId(6);
//	}

}
