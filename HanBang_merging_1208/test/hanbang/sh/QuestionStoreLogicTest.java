package hanbang.sh;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.Question;
import hanbang.store.QuestionStore;
import hanbang.store.logic.QuestionStoreLogic;

public class QuestionStoreLogicTest {
	
	private QuestionStore store;
	
	@Before
	public void setUp() {
		store = new QuestionStoreLogic();
	}

	@Test
	public void testCreate() {
		Question question = new Question();
		question.setPhoneNumber("111");
		question.setQuestionContent("test1");
		question.setSchedule("17.11.24");
		question.setShareHouseId(1);
		question.setWriterId("sh");
		store.create(question);
		assertNotNull(question);
	}

//	@Test
//	public void testRetriveByMemberId() {
//		List<Question> list = store.retriveByMemberId("sss");
//		assertEquals("test11", list.get(0).getQuestionContent());
//		assertEquals(1, list.size());
//	}

//	@Test
//	public void testRetriveByShareHouseId() {
//		List<Question> list = store.retriveByShareHouseId(8);
//		assertNotNull(list);
//		assertEquals(3, list.size());
//	}

//	@Test
//	public void testRetrive() {
//		Question question = store.retrive(24);
//		assertNotNull(question);
//		assertEquals("sh", question.getWriterId());
//	}
//
//	@Test
//	public void testUpdate() {
//		Question question = store.retrive(24);
//		question.setQuestionContent("ㅇㅇ");
//		store.update(question);
//		assertEquals("sh", question.getWriterId());
//	}

//	@Test
//	public void testDelete() {
//		store.delete(21);
//		
//	}

//	@Test
//	public void testDeleteByMemberId() {
//		store.deleteByMemberId("sss");
//	}

//	@Test
//	public void testDeleteByShareHouse() {
//		store.deleteByShareHouse(8);
//	}

}
