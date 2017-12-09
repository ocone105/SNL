package hanbang.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hanbang.domain.Member;
import hanbang.store.MemberStore;
import hanbang.store.factory.SqlSessionFactoryProvider;
import hanbang.store.mapper.MemberMapper;

@Repository
public class MemberStoreLogic implements MemberStore {

	@Override
	public int create(Member member) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		int check;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check = mapper.create(member);
			session.commit();
		} finally {
			session.close();
		}

		return check;

	}

	@Override
	public List<Member> retriveAll() {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		List<Member> list = null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.retriveAll();

		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Member retrive(String memberId) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		Member member;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			member = mapper.retrive(memberId);
		} finally {
			session.close();
		}
		return member;
	}

	@Override
	public int update(Member member) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		int check;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check = mapper.update(member);
			session.commit();

		} finally {
			session.close();
		}
		return check;
	}

	@Override
	public int delete(String memberId) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		int check;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			check = mapper.delete(memberId);
			session.commit();
		} finally {
			session.close();
		}

		return check;
	}

	@Override
	public List<Member> retriveByMemberType(int memberType) {
		SqlSession session = SqlSessionFactoryProvider.getSqlSessionFactory().openSession();
		List<Member> list = null;

		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.retriveByMemberType(memberType);

		} finally {
			session.close();
		}

		return list;
	}



}
