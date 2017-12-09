package hanbang.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.Answer;
import hanbang.domain.Member;
import hanbang.domain.Paging;
import hanbang.domain.Question;
import hanbang.domain.ShareHouse;
import hanbang.service.MemberService;
import hanbang.service.QuestionService;
import hanbang.service.ShareHouseService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService service;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ShareHouseService shareHouseService;

	@RequestMapping("/question/registQuestion.do")
	public String registerQuestion() {
		return "redirect:/views/questionCreate.jsp";
	}

	// 문의 등록
	@RequestMapping(value = "/question/registQuestion.do", method = RequestMethod.POST)
	public String registerQuestion(int shareHouseId, String schedule, String phoneNumber, String content,
			HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		Member member = memberService.find(memberId);
		if (member.getMemberTypeId() == 1) {
			return "redirect:questionList.do";
		} else {
			Question question = new Question();
			question.setWriterId(memberId);
			question.setShareHouseId(shareHouseId);
			question.setSchedule(schedule);
			question.setPhoneNumber(phoneNumber);
			question.setQuestionContent(content);
			boolean registed = service.register(question);
			if (!registed) {
				return "redirect:/question/registQuestion.do";
			}
			return "questionList.do";
		}
	}

	// 문의 조회
	@RequestMapping("/question/questionList.do")
	public String findQuestion(HttpSession session, Model model, String chosenMember) {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberService.find(memberId);

		if (member.getMemberTypeId() == 1) {
			// 일반 회원일 경우
			List<Question> questionList = null;
			try {
				questionList = service.findByMemberId(memberId);

				Paging paging = new Paging();
				paging.setPageNo(1);
				paging.setPageSize(10);
				paging.setTotalCount(questionList.size());
			} catch (Exception e) {
				e.printStackTrace();
				return "/views/questionList.jsp";
			}

			model.addAttribute("questionList", questionList);
			return "/views/questionList.jsp";

		} else if (member.getMemberTypeId() == 2) {
			// 사업자일 경우
			List<ShareHouse> shareHouses = shareHouseService.findByMemberId(memberId);
			List<Question> questionList = null;
			try {
				for (int i = 0; i < shareHouses.size(); i++) {
					questionList = service.findByShareHouseId(shareHouses.get(0).getShareHouseId());
				}
				Paging paging = new Paging();
				paging.setPageNo(1);
				paging.setPageSize(10);
				paging.setTotalCount(questionList.size());
			} catch (Exception e) {
				e.printStackTrace();
				return "/views/questionList.jsp";
			}
			model.addAttribute("qeustionList", questionList);
			return "/views/questionList.jsp";
		} else {
			// admin인 경우
			List<Question> list = null;
			try {
				list = service.findByMemberId(chosenMember);
			} catch (Exception e) {
				e.printStackTrace();
				return "/views/questionList.jsp";
			}
			model.addAttribute("questionList", list);
			return "/views/questionList.jsp";
		}
	}

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
	// @RequestMapping("/question/modifyQuestion.do")
	// public String modifyQuestion(int questionId, HttpSession session, Model
	// model) {
	// String memberId = (String)session.getAttribute("loginedUser");
	// Question question = service.find(questionId);
	// if(question.getWriterId().equals(memberId)) {
	// model.addAttribute(question);
	// return "modifyQuestion.jsp";
	// } else {
	// return "questionDetail.do";
	// }
	// }

	//
	// @RequestMapping(value="/question/modifyQuestion.do",
	// method=RequestMethod.POST)
	// public String modifyQuestion(Question question, Model model) {
	// service.modify(question);
	// model.addAttribute(question);
	// return "detailQuestion.do";
	// }

	// 문의 삭제
	@RequestMapping("/question/removeQuestion.do")
	public String removeQuestion(int questionId, HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		Question ques = service.find(questionId);

		if (ques.getWriterId().equals(memberId)) {
			// 로그인 한 회원이 작성한 문의일 경우
			boolean check = service.remove(questionId);
			if (check == false) {
				return "redirect:detailQuestion.do?questionId=" + questionId;
			} else {
				return "redirect:questionList.do";
			}
		} else {
			// 로그인 한 회원이 작성한 문의가 아닐 때
			return "redirect:detailQuestion.do?questionId=" + questionId;
		}

	}

}
