package hanbang.sh;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.Answer;
import hanbang.store.ReviewAnswerStore;
import hanbang.store.logic.ReviewAnswerStoreLogic;

public class ReviewAnswerStoreLogicTest {
	
	private ReviewAnswerStore store;
	
	@Before
	public void setUp() {
		store = new ReviewAnswerStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		Answer answer = new Answer();
//		answer.setContent("222");
//		answer.setQuesOrReviewId(12);
//		answer.setWriterId("ms");
//		answer.setTypeId(2);
//		store.create(answer);
//		assertNotNull(answer);
//	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteByReviewId() {
	}

	@Test
	public void testDeleteByAnswerId() {
	}

	@Test
	public void testRetrieveAll() {
		List<Answer> list = store.retrieveAll(12);
		assertEquals(2, list.size());
	}

	@Test
	public void testRetrieveByAnswerId() {
	}

}
