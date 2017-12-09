package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.Member;

public interface MemberMapper {
	int create(Member member);

	List<Member> retriveAll();
	
	List<Member> retriveByMemberType(int memberType);
	
	Member retrive(String memberId);

	int update(Member member);

	int delete(String memberId);

}
