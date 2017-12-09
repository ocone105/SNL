package hanbang.sr;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hanbang.domain.Member;
import hanbang.service.MemberService;
import hanbang.service.logic.MemberServiceLogic;

public class MemberServiceLogicTest {

	private MemberService service;

	@Before
	public void setUp() {
		service = new MemberServiceLogic();
	}
	// @Test
	// public void testRegister() {
	// Member member = new Member();
	// member.setId("thfkthfk");
	// member.setPassword("ssss1128");
	// member.setName("testd");
	// member.setPhoneNumber("0105225332");
	// member.setEmail("ggg@nate");
	// member.setMemberTypeId(2);
	// service.register(member);
	// }

	@Test
	public void testFindAll() {
		List<Member> list = service.findAll();

		assertEquals(1, list.size());
	}

	// @Test
	// public void testFind() {
	//
	// Member member = service.find("test");
	// assertNotNull(member);
	// }
	//
	// @Test
	// public void testModify() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testRemove() {
	// service.remove("test");
	// }

}
