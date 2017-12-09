package hanbang.sr;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.Member;
import hanbang.store.MemberStore;
import hanbang.store.logic.MemberStoreLogic;

public class MemberStoreLogicTest {
	
	private MemberStore store;
	
	@Before
	public void setUP() {
		store = new MemberStoreLogic();
	}

//	@Test
//	public void testCreate() {
//		Member member = new Member();
//		member.setId("sora525");
//		member.setPassword("1525");
//		member.setName("ss");
//		member.setPhoneNumber(01055332);
//		member.setEmail("th_fkcdsc@nate.com");
//		member.setMemberTypeId(2);
//		store.create(member);
//		assertNotNull(member);
//	}
//
//	@Test
//	public void testRetriveAll() {
//		List<Member> list = store.retriveAll();
//		assertEquals(2, list.size());
//	}
//
	@Test
	public void testRetrive() {
		Member member = store.retrive("sora525");
		System.out.println(member.getId());
		assertEquals("test1234", member.getPhoneNumber());
		
	}

//	@Test
//	public void testUpdate() {
//		Member member = store.retrive("sora525");
//		System.out.println(member.getId());
//		member.setPhoneNumber("test1234");
//		store.update(member);
//	}

//	@Test
//	public void testDelete() {
//		store.delete("sora525");
//		
//	}

}
