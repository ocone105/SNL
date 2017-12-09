package hanbang.controller;

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
public class QuestionAnswerController {
	
	@Autowired
	private AnswerService service;
	@Autowired
	private MemberService memberService;
	
	// 문의 댓글 등록
	@RequestMapping(value="/question/registAnswer.do", method=RequestMethod.POST)
	public String registAnswer(String content, int questionId, HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("memberId");
		Member member = memberService.find(memberId);
		
		Answer answer = new Answer();
		answer.setWriterId(memberId);
		answer.setContent(content);
		answer.setQuesOrReviewId(questionId);
		answer.setTypeId(member.getMemberTypeId());
		boolean check = service.registerQuestion(answer);
		if(check == false) {
			return "redirect:detailQuestion.do?questionId=" + questionId;
		} else {
			model.addAttribute(answer);
			return "redirect:detailQuestion.do?questionId=" + questionId;
		}
	}
	
	//문의 댓글 삭제
	@RequestMapping(value="/question/removeAnswer.do", method=RequestMethod.GET)
	public String removeAnswer(int answerId, int questionId, HttpSession session) {
		String memberId = (String)session.getAttribute("memberId");
		Answer answer = service.findQuestionAnswerById(answerId);
		
		if(answer.getWriterId().equals(memberId)) {
			boolean check = service.removeByQuesAnswerId(answerId);
			if(check == true) {
				return "detailQuestion.do?questionId=" + questionId;
			} else {
				return "detailQuestion.do?questionId=" + questionId;
			}
		} else {
			return "redirect:/detailQuestion.do?questionId=" + questionId;
		}
	}
	
	
}
