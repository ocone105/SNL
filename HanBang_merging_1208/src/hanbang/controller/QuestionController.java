package hanbang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.Answer;
import hanbang.domain.Paging;
import hanbang.domain.Question;
import hanbang.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@RequestMapping("/question/registQuestion.do")
	public String registerQuestion() {
		return "redirect:/views/questionCreate.jsp";
	}
	
	// 문의 등록
	@RequestMapping(value="/question/registQuestion.do", method=RequestMethod.POST)
	public String registerQuestion(String schedule, String phoneNumber, String content, HttpSession session) {
		Question question = new Question();
		question.setWriterId("sh");
		question.setShareHouseId(1);
		question.setSchedule(schedule);
		question.setPhoneNumber(phoneNumber);
		question.setQuestionContent(content);
		boolean registed = service.register(question);
		if(!registed) {
			return "redirect:/question/registQuestion.do";
		}
		return "questionList.do";
	}
	
	// 문의 조회
	@RequestMapping("/question/questionList.do")
	public String findQuestion(HttpSession session, Model model) {
//		String memberId = null;
//		if(session.getAttribute("loginedUser").equals(null)) {
//			memberId = "sh";
//		} else {
//			memberId = (String)session.getAttribute("loginedUser");
//		}
//		List<Question> questionList = service.findByMemberId(memberId);
//		model.addAttribute(questionList);
		int memberType = 1;
		List<Question> questionList = service.findByMemberId("sh");
		model.addAttribute(questionList);
		model.addAttribute(memberType);
		
		Paging paging = new Paging();
		paging.setPageNo(1);
		paging.setPageSize(10);
		paging.setTotalCount(questionList.size());
		
		return "/views/questionList.jsp";
	}
	
	
////	문의 리스트 조회 (페이징)
//	@RequestMapping("/question/list")
//	public ModelAndView list(Question question) {
//		List<Question> questionList = service.findByMemberId(question.getWriterId());
//		Model
//		
//		Paging paging = new Paging();
//		paging.setPageNo(1);
//		paging.setPageSize(10);
//		paging.setTotalCount(totalCount);
//	}
//	
	
	// 문의 상세 조회
	@RequestMapping("/question/detailQuestion.do")
	public String detailQuestion(int questionId, Model model) {
		Question question = service.find(questionId);
		model.addAttribute("question", question);
		List<Answer> answers = question.getAnswers();
		model.addAttribute("answers", answers);
		return "/views/questionDetail.jsp";
	}
	
	// 문의 수정
	@RequestMapping("/question/modifyQuestion.do")
	public String modifyQuestion(int questionId, HttpSession session, Model model) {
		String memberId = (String)session.getAttribute("loginedUser");
		Question question = service.find(questionId);
		if(question.getWriterId().equals(memberId)) {
			model.addAttribute(question);
			return "modifyQuestion.jsp";
		} else {
			return "questionDetail.do";
		}
	}
	
	//
	@RequestMapping(value="/question/modifyQuestion.do", method=RequestMethod.POST)
	public String modifyQuestion(Question question, Model model) {
		service.modify(question);
		model.addAttribute(question);
		return "detailQuestion.do";
	}
	
	// 문의 삭제
	@RequestMapping("/question/removeQuestion.do")
	public String removeQuestion(int questionId) {
		boolean check = service.remove(questionId);
		if(check == false) {
			System.out.println(" * questionRemoveFalse!");
			return "redirect:questionList.do";
		} else {
			System.out.println(" * questionRemoveTrue!");
			return "redirect:questionList.do";
		}
	}
	
}













