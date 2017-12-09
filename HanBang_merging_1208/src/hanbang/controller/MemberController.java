package hanbang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hanbang.domain.House;
import hanbang.domain.Member;
import hanbang.domain.ShareHouse;
import hanbang.service.HouseService;
import hanbang.service.MemberService;
import hanbang.service.ReviewService;
import hanbang.service.ShareHouseService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	@Autowired
	private HouseService houseService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ShareHouseService shareHouseService;

	@RequestMapping(value = "memberJoin.do", method = RequestMethod.POST)
	public String registerMember(Member member) {

		service.register(member);
		return "redirect:/views/login.jsp";
	}

	// 사업자 리스트
	@RequestMapping(value = "providerList.do", method = RequestMethod.GET)
	public String findAllProvider(Model model) {
		List<Member> members = service.findByMemberType(2);
		List<ShareHouse> houses = shareHouseService.findAll();
		Map<String ,Object> map = new HashMap<>();
		for(Member m : members) {
			
			List<ShareHouse> s = shareHouseService.findByMemberId(m.getId());
			int temp = s.size();
			map.put(m.getId(), temp);
		}
		System.out.println("$$$$$"+ map.size());
		
		model.addAttribute("map" ,map);
		model.addAttribute("members", members);
		model.addAttribute("shareHouses", houses);
		return "views/memberProviderList.jsp";
	}

	// 일반회원 리스트
	@RequestMapping(value = "userList.do", method = RequestMethod.GET)
	public String findAllUser(Model model) {
		List<Member> members = service.findByMemberType(1);

//		 List<Review> reviews = reviewService.fi

		model.addAttribute("members", members);
		// model.addAttribute("size", size);
		return "views/memberUserList.jsp";
	}

	// 전체회원
	@RequestMapping(value = "allMemberList.do", method = RequestMethod.GET)
	public String findAllMember(Model model) {
		List<Member> members = service.findAll();

		model.addAttribute("members", members);
		model.addAttribute("size", members.size());
		return "views/allMemberList.jsp";
	}

	@RequestMapping(value = "findMember.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String findByMemberId(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("memberId");
		Member member = service.find(memberId);
		List<House> houses = houseService.findByMemberId(memberId);

		model.addAttribute("member", member);
		model.addAttribute("houses", houses);

		return "/views/memberDetail.jsp";
	}

	@RequestMapping(value = "adminFindMember.do", method = RequestMethod.GET)
	public String adminFindByMemberId(String memberId, Model model) {
		Member member = service.find(memberId);
		List<House> houses = houseService.findByMemberId(memberId);

		model.addAttribute("member", member);
		model.addAttribute("houses", houses);

		return "/views/memberDetail.jsp";
	}

	@RequestMapping(value = "modifyMember.do", method = RequestMethod.GET)
	public String modifyMember(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("memberId");
		Member member = service.find(memberId);

		model.addAttribute("member", member);
		return "/views/memberModify.jsp";
	}

	@RequestMapping(value = "modifyMember.do", method = RequestMethod.POST)
	public String modifyMember(Member member, Model model) {

		service.modify(member);
		return "redirect:/findMember.do?memberId=" + member.getId();

	}

	@RequestMapping(value = "removeMember.do")
	public String removeMember(HttpSession session, String memberId) {
		String id = (String) session.getAttribute("memberId");
		if ("admin".equals(id)) {
			service.remove(memberId);
			return "allMemberList.do";
		} else {
			service.remove(id);
			session.invalidate();
			return "redirect:/index.do";
		}
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String memberId, String password, HttpServletResponse response) {

		Member member = service.find(memberId);
		HttpSession session = request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;

		if (member != null) {
			if (member.getPassword().equals(password)) {
				session.setAttribute("memberId", memberId);
				session.setAttribute("name", member.getName());
				session.setAttribute("memberType", member.getMemberTypeId());

				System.out.println(member.getMemberTypeId());
				if (member.getMemberTypeId() == 2) {
					List<House> houses = houseService.findByMemberId(memberId);
					if (houses.size() == 0) {
						return "redirect:/views/houseCreate.jsp";
					} else {
						return "redirect:/index.do";
					}
				} else {
					return "redirect:/index.do";
				}
			} else {
				try {
					out = response.getWriter();
					out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "/views/login.jsp";
			}
		} else {
			try {
				out = response.getWriter();
				out.println("<script>alert('로그인 정보를 확인해주세요.'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "/views/login.jsp";
		}

	}

	@RequestMapping(value = "logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/views/login.jsp";
	}
	
	@ResponseBody
	@RequestMapping("/checkId.do")
	public String checkMemberID(String memberId, Model model) {
	   if(service.find(memberId) == null){
	      return "success";
	   }else{
	   return "fail";
	   }
	}

}