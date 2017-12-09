package hanbang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.Answer;
import hanbang.domain.Member;
import hanbang.service.AnswerService;
import hanbang.service.MemberService;

@Controller
public class ReviewAnswerController {
	
	@Autowired
	private AnswerService service;
	@Autowired
	private MemberService memberService;
	
	// 후기 댓글 등록
	@RequestMapping(value="/review/registAnswer.do", method=RequestMethod.POST)
	public String registAnswer(int reviewId, HttpSession session, Model model, String content) {
		String memberId = (String)session.getAttribute("memberId");
		Member member = memberService.find(memberId);
		
		Answer answer = new Answer();
		answer.setTypeId(member.getMemberTypeId());
		answer.setContent(content);
		answer.setWriterId(memberId);
		answer.setQuesOrReviewId(reviewId);
		boolean check = service.registerReview(answer);
		if(check == false) {
			return "redirect:detailReview.do?reviewId=" + reviewId;
		} else {
			model.addAttribute(answer);
			return "redirect:detailReview.do?reviewId=" + reviewId;
		}
	}
	
	// 후기 댓글 수정
	@RequestMapping(value="/review/modifyAnswer.do", method=RequestMethod.POST)
	public String modifyAnswer(HttpServletRequest request, HttpSession session) {
		
		return "";
	}
	
	// 후기 댓글 삭제
	@RequestMapping("/review/removeAnswer.do")
	public String removeAnswer(int answerId, int reviewId) {
		boolean check = service.removeByAnswerId(answerId);
		if(check==false) {
			return "detailReview.do?reviewId=" + reviewId;
		} else {
			return "detailReview.do?reviewId=" + reviewId;
		}
	}
	
	
	// 후기 댓글 삭제
	

}
