package hanbang.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.House;
import hanbang.domain.InterestShareHouse;
import hanbang.domain.Room;
import hanbang.domain.ShareHouse;
import hanbang.service.HouseService;
import hanbang.service.InterestShareHouseService;
import hanbang.service.RoomService;

@Controller
public class InterestShareHouseController {

	@Autowired
	private InterestShareHouseService service;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HouseService houseService;

	@RequestMapping(value = "registInterstHouse.do")
	public String registerInterstHouse(InterestShareHouse interstHouse, int shareHouseId, HttpSession session,
			Model model) {
		String memberId = (String) session.getAttribute("memberId");
		interstHouse.setMemberId(memberId);
		boolean registed = service.register(interstHouse);
		if (!registed) {
			// 이미 저장되있을때
			service.removeInterestShareHouse(memberId, shareHouseId);
			return "redirect:/ShareHouseDetail.do?shareHouseId=" + shareHouseId;
		} else {
			return "redirect:/ShareHouseDetail.do?shareHouseId=" + shareHouseId;
		}
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
		System.out.println("##########" + shareHouseId);
		service.remove(shareHouseId);
		return "interestShareHouseList.do";
	}

}