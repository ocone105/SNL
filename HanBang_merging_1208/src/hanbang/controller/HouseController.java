package hanbang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hanbang.domain.House;
import hanbang.service.HouseService;

@Controller
public class HouseController {

	@Autowired
	private HouseService service;

	@RequestMapping(value = "/houseRegister.do", method = RequestMethod.POST)
	public String registerHouse(House house, Model model, HttpSession session) {

		String memberId = (String) session.getAttribute("memberId");
		house.setMemberId(memberId);

		boolean registed = service.register(house);
		if (!registed) {

			return "redirect:/houseCreate.jsp";
		} else {
			model.addAttribute("house", house);
			return "redirect:/findMember.do?memberId=" + memberId;
		}
	}

	@RequestMapping(value = "/houseModify.do", method = RequestMethod.GET)
	public String modifyHouse(String houseId, Model model) {

		int id = Integer.parseInt(houseId);
		House house = service.findMyHouse(id);

		model.addAttribute("house", house);

		return "/views/houseModify.jsp";

	}

	@RequestMapping(value = "/houseModify.do", method = RequestMethod.POST)
	public String modifyHouse(House house) {
		
		service.modify(house);
		
		return "redirect:/findMember.do?memberId=" + house.getMemberId();
	}

	@RequestMapping(value = "/houseDelete.do")
	public String removeHouse(String houseId) {
		
		
		House house = service.findMyHouse(Integer.parseInt(houseId));
		
		String memberId = house.getMemberId();
		service.remove(Integer.parseInt(houseId));

		return "redirect:/findMember.do?memberId=" + memberId;
	}

}
