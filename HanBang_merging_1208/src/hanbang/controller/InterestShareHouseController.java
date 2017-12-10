package hanbang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.House;
import hanbang.domain.InterestShareHouse;
import hanbang.domain.ShareHouse;
import hanbang.service.HouseService;
import hanbang.service.InterestShareHouseService;

@Controller
public class InterestShareHouseController {

	@Autowired
	private InterestShareHouseService service;
	@Autowired
	private HouseService houseService;

	@RequestMapping(value = "registInterstHouse.do")
	public String registerInterstHouse(HttpServletRequest request, HttpServletResponse response,
			InterestShareHouse interstHouse, int shareHouseId, HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("memberId");
		interstHouse.setMemberId(memberId);

		List<ShareHouse> list = service.findAll(memberId);
		for (ShareHouse s : list) {
			int id = s.getShareHouseId();
			if (id == shareHouseId) {
				response.setCharacterEncoding("EUC-KR");
				PrintWriter writer;
				try {
					writer = response.getWriter();
					writer.println("<script type='text/javascript'>");
					writer.println("alert('♥이미등록된 관심하우스 입니다♥');");
					writer.println("history.back();");
					writer.println("</script>");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		service.register(interstHouse);
		response.setCharacterEncoding("EUC-KR");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script type='text/javascript'>");
			writer.println("alert('♥관심하우스로 등록되었습니다♥');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/shareHouse/shareHouseDetail.do?shareHouseId=" + shareHouseId;

	}

	@RequestMapping(value = "interestShareHouseList.do", method = RequestMethod.GET)
	public String findInterestShareHouse(HttpSession session, Model model) {
		String memberId = (String) session.getAttribute("memberId");
		List<ShareHouse> list = service.findAll(memberId);
		List<House> house = houseService.findAll();

		model.addAttribute("interestShareHouses", list);
		model.addAttribute("houses", house);

		return "/views/interestShareHouseList.jsp";
	}

	// 리스트에서 삭제할때
	@RequestMapping(value = "interestShareHouseDelete.do")
	public String removeShareHouse(int shareHouseId) {
		service.remove(shareHouseId);
		return "interestShareHouseList.do";
	}

}