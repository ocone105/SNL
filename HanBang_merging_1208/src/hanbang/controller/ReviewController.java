package hanbang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hanbang.domain.Answer;
import hanbang.domain.Member;
import hanbang.domain.Review;
import hanbang.domain.ShareHouse;
import hanbang.service.MemberService;
import hanbang.service.ReviewService;
import hanbang.service.ShareHouseService;

//@MultipartConfig(maxFileSize=1024*1024*1024, location="C:/Users/limsuhyun/eclipse-workspace/HanBang/WebContent/file")
@Controller
public class ReviewController {

	@Autowired
	private ReviewService service;
	@Autowired
	private MemberService memberService;
	@Autowired
	private ShareHouseService shareHouseService;

	// 후기 등록
	@RequestMapping("/review/registReview.do")
	public String registerReview(Model model, String shareHouseId) {

		int id = Integer.parseInt(shareHouseId);
		ShareHouse shareHouse = shareHouseService.find(id);

		model.addAttribute("shareHouse", shareHouse);

		return "/views/reviewCreate.jsp";
	}

	//
	@RequestMapping(value = "/review/registReview.do", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile imgFile, Model model, Review review,
			HttpSession session, String shareHouseId) {

		String memberId = (String) session.getAttribute("memberId");
		Member member = memberService.find(memberId);

		int id = Integer.parseInt(shareHouseId);

		String rename = null;
		String fullPath = null;
		String savePath = "C:/Users/limsuhyun/git/HanBang/HanBang/WebContent/uploadFile";
		String originalFilename = imgFile.getOriginalFilename() + ""; // fileName.jpg
		if (!originalFilename.isEmpty()) {
			String onlyFileName = originalFilename.substring(0, originalFilename.indexOf(".")); // fileName
			String extension = originalFilename.substring(originalFilename.indexOf("."));
			rename = onlyFileName + "_" + getCurrentDayTime() + extension; // fileName_20150721-14-07-50.jpg
			fullPath = savePath + "\\" + rename;
		}

		review.setWriterId(memberId);
		review.setShareHouseId(member.getMemberTypeId());
		review.setPhoto(rename);
		review.setShareHouseId(id);

		service.register(review);
		model.addAttribute(review);
		// List<Answer> list = answerService.findReview(reviewId);

		if (!imgFile.isEmpty()) {
			try {
				byte[] bytes = imgFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				// model.addAttribute("resultMsg", "파일을 업로드 성공!");
			} catch (Exception e) {
				// model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
			}
		} else {
			// model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}
		int reviewId = review.getReviewId();
		return "redirect:detailReview.do?reviewId=" + reviewId;
	}

	// 시간정보
	public String getCurrentDayTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
		return dayTime.format(new Date(time));
	}

	// 후기 상세 조회
	@RequestMapping("/review/detailReview.do")
	public String detailReview(int reviewId, Model model) {
		Review review = service.find(reviewId);
		model.addAttribute(review);
		List<Answer> answers = review.getAnswers();
		model.addAttribute("answers", answers);
		return "/views/reviewDetail.jsp";
	}

	// 후기 수정
	@RequestMapping("/review/modifyReview.do")
	public String modifyReview(int reviewId, HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("memberId");
		Review review = service.find(reviewId);
		if (review.getWriterId().equals(memberId)) {
			model.addAttribute("review", review);
			return "/views/reviewModify.jsp";
		} else {
			return "redirect:reviewDetail.do?reviewId=" + reviewId;
		}
	}

	//
	@RequestMapping(value = "/review/modifyReview.do", method = RequestMethod.POST)
	public String modifyReview(int reviewId, Review review, Model model) {
		try {
			boolean check = service.modify(review);
			if (check == false) {
				model.addAttribute("review", review);
				return "redirect:modifyReview.do?reviewId=" + reviewId;
			} else {
				model.addAttribute(review);
				return "detailReview.do?reviewId=" + reviewId;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:modifyReview.do?reviewId=" + reviewId;
		}
	}

	// 후기 삭제(reviewId)
	@RequestMapping("/review/removeReviewByReviewId.do")
	public String removeReviewByReviewId(int reviewId, HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		Review review = service.find(reviewId);
		if (review.getWriterId().equals(memberId)) {
			boolean check = service.removeByReviewId(reviewId);
			if (check == false) {
				return "redirect:detailReview.do?reviewId=" + reviewId;
			} else {
				// shareHouseDetail.do에서 reviewList 뿌려줘야 함!!!!!!!!!
				return "redirect:reviewList.do";
			}
		} else {
			return "redirect:detailReview.do?reviewId=" + reviewId;
		}
	}

	// 후기 삭제(memberId)
	@RequestMapping("/review/removeReviewByMemberId.do")
	public String removeReviewByMemberId(int reviewId, HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		Review review = service.find(reviewId);

		if (review.getWriterId().equals(memberId)) {
			boolean check = service.removeByMemberId(memberId);
			if (check == false) {
				return "redirect:reviewDetail.do";
			} else {
				// shareHouseDetail 에서 보여줘야하는 뷰!!!!!!!
				return "redirect:reviewList.do";
			}
		} else {
			return "redirect:/detailReview.do?reviewId=" + reviewId;
		}
	}

	// ShareHouseController.
	// 후기 삭제(shareHouseId)
	@RequestMapping("/review/removeReviewByShareHouseId.do")
	public String removeReviewShareHouseId(int shareHouseId) {
		boolean check = service.removeByShareHouse(shareHouseId);
		if (check == false) {
			return "redirect:reviewDetail.do";
		} else {
			return "redirect:reviewList.do";
		}
	}

	// 후기 신고
	@RequestMapping("/review/reportReview.do")
	public String reportReview(HttpSession session, int reviewId) {
		// String memberId = (String) session.getAttribute("loginedUser");
		String memberId = "rr";

		try {
			boolean check = service.reportReview(memberId, reviewId);
			System.out.println("*check : " + check);
			if (check == false) {
				// System.out.println(" WHY FALSE ? ");
				return "redirect:detailReview.do?reviewId=" + reviewId;
			} else {
				// System.out.println("******Review REPORTED ! ");
				// 후기 숫자 확인 후 자동 삭제
				List<Integer> list = service.countReportReview(reviewId);
				// System.out.println("@@@@reviewReportCount.size()" + list.size());
				if (list.size() >= 2) {
					boolean removeReports = service.removeReportedReviews(reviewId);
					if (removeReports == false) {
						// System.out.println(" REMOVE REPORTS FALSE");
						return "redirect:registReview.do";
					} else {
						service.removeByReviewId(reviewId);
						// System.out.println("**************Review REPORTED &&&&& DELETED BY REVIEWID
						// !");
						return "redirect:registReview.do";
					}
				} else {
					// System.out.println("REVIEW REPORTED AND REDIRECTED ! *************8");
					return "redirect:detailReview.do?reviewId=" + reviewId;
				}
			}
		} catch (Exception e) {
			System.out.println(" report review EXCEPTION !");
			e.printStackTrace();
			return "redrect:detailReview.do?reviewId=" + reviewId;
		}
		// try {
		// boolean check = service.reportReview(memberId, reviewId);
		// System.out.println("*check : " + check);
		// if(check == false) {
		// System.out.println(" WHY FALSE ? ");
		// return "redirect:detailReview.do?reviewId=" + reviewId;
		// } else {
		// System.out.println("******Review REPORTED ! ");
		// // 후기 숫자 확인 후 자동 삭제
		// List<Integer> list = service.countReportReview(reviewId);
		// System.out.println("@@@@reviewReportCount.size()" + list.size());
		// if(list.size() >= 2) {
		// service.removeByReviewId(reviewId);
		// System.out.println("**************Review REPORTED &&&&& DELETED BY REVIEWID
		// !");
		// return "redirect:registReview.do";
		// } else {
		// System.out.println("REVIEW REPORTED AND REDIRECTED ! *************8");
		// return "redirect:detailReview.do?reviewId=" + reviewId;
		// }
		// }
		// } catch (Exception e) {
		// System.out.println(" ***** constraint violated !!");
		// return "redirect:detailReview.do?reviewId=" + reviewId;
		// }
	}

}
