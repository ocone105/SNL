package hanbang.store;

import java.util.List;

import hanbang.domain.Member;

public interface MemberStore {

	int create(Member member);

	List<Member> retriveAll();
	
	List<Member> retriveByMemberType(int memberType);

	Member retrive(String memberId);

	int update(Member member);

	int delete(String memberId);

}
