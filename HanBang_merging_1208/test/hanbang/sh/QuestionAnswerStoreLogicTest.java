package hanbang.sh;


import org.junit.Before;
import org.junit.Test;

import hanbang.store.QuestionAnswerStore;
import hanbang.store.logic.QuestionAnswerStoreLogic;

import static org.junit.Assert.*;


import hanbang.domain.Answer;

public class QuestionAnswerStoreLogicTest {
	
	private QuestionAnswerStore store;
	
	@Before
	public void setUp() {
		store = new QuestionAnswerStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		Answer answer = new Answer();
//		answer.setContent("test2");
//		answer.setQuesOrReviewId(22);
//		answer.setWriterId("sh");
//		answer.setTypeId(1);
//		store.create(answer);
//		assertNotNull(answer);
//	}

//	@Test
//	public void testRetrieveAll() {
//		List<Answer> list = store.retrieveAll(22);
//		assertEquals(2, list.size());
//	}
	
	@Test
	public void testRetrieveByAnswerId() {
		Answer answer = store.retrieveByAnswerId(25);
		assertEquals("ms", answer.getWriterId());
	}

	@Test
	public void testUpdate() {
		Answer answer = store.retrieveByAnswerId(25);
		answer.setContent("11");
		store.update(answer);
		assertEquals("ms", answer.getWriterId());
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteByQuestionId() {
	}

	@Test
	public void testDeleteByAnswerId() {
	}

}
