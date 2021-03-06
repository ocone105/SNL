package hanbang.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hanbang.domain.EssentialInfo;
import hanbang.domain.ExtraInfo;
import hanbang.domain.House;
import hanbang.domain.Photo;
import hanbang.domain.Review;
import hanbang.domain.Room;
import hanbang.domain.ShareHouse;
import hanbang.service.EssentialInfoService;
import hanbang.service.ExtraInfoService;
import hanbang.service.HouseService;
import hanbang.service.ReviewService;
import hanbang.service.RoomService;
import hanbang.service.ShareHouseService;

@Controller
public class ShareHouseController {
	@Autowired
	private HouseService houseService;
	@Autowired
	private ShareHouseService shareHouseService;
	@Autowired
	private EssentialInfoService essentialInfoService;
	@Autowired
	private ExtraInfoService extraInfoService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/registShareHouse.do", method = RequestMethod.GET)
	public String registerShareHouse(Model model, int houseId) {

		House house = houseService.findMyHouse(houseId);

		model.addAttribute("house", house);

		return "/views/shareHouseCreate.jsp";
	}

	@RequestMapping(value = "/registShareHouse.do", method = RequestMethod.POST)
	public String registerShareHouse(HttpSession session, String content, String title, ExtraInfo extraInfo,
			String buildingType, String parking, String floorTotalFloor, String lift, Room room,
			MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IOException {

		/* shareHouse create */
		String memberId = (String) session.getAttribute("memberId");
		ShareHouse shareHouse = new ShareHouse();
		shareHouse.setWriterId(memberId);
		int houseId = Integer.parseInt(request.getParameter("houseId"));
		shareHouse.setHouseId(houseId);
		shareHouse.setContent(content);
		shareHouse.setTitle(title);
		int shareHouseId = shareHouseService.register(shareHouse);

		/* room create */
		String[] provodedGood = request.getParameterValues("providedGood");
		List<String> providedGoods = new ArrayList<String>(Arrays.asList(provodedGood));
		String sex = request.getParameter("shareHouseGender");
		room.setSex(sex);
		room.setShareHouseId(shareHouseId);
		roomService.register(room, providedGoods);

		/* extraInfo shareHouseId set */
		if (extraInfo.getPet() == null) {
			extraInfo.setPet("불가");
		}
		if (extraInfo.getSmoke() == null) {
			extraInfo.setSmoke("불가");
		}
		extraInfo.setShareHouseId(shareHouseId);
		extraInfoService.register(extraInfo);

		/* essentialInfo create */
		EssentialInfo essentialInfo = new EssentialInfo();
		essentialInfo.setBuildingType(buildingType);
		essentialInfo.setFloorTotalFloor(floorTotalFloor);
		if (parking == null) {
			parking = "불가";
			essentialInfo.setParking(parking);
		} else {
			essentialInfo.setParking(parking);
		}
		if (lift == null) {
			lift = "없음";
			essentialInfo.setLift(lift);
		} else {
			essentialInfo.setLift(lift);
		}
		String[] publicUsage = request.getParameterValues("publicUsage");
		List<String> usages = new ArrayList<String>(Arrays.asList(publicUsage));
		essentialInfo.setShareHouseId(shareHouseId);
		essentialInfoService.register(essentialInfo, usages);

		/* photo create */
		String realFolder = "c:/tempFiles/";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		List<MultipartFile> mf = mhsq.getFiles("photos");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				String genId = UUID.randomUUID().toString();
				String originFileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + originFileName;

				File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);
				byte[] bytes = mf.get(i).getBytes();
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				shareHouseService.savePhoto(saveFileName, shareHouse.getShareHouseId());
			}
		}

		return "/shareHouse/shareHouseDetail.do?shareHouseId=" + shareHouseId;
	}

	@RequestMapping(value = "/shareHouse/shareHouseModify.do", method = RequestMethod.GET)
	public String modifyShareHouse(String shareHouseId, Model model, HttpSession session) {

		String memberId = (String) session.getAttribute("memberId");
		int id = Integer.parseInt(shareHouseId);
		ShareHouse shareHouse = shareHouseService.find(id);
		int houseId = shareHouse.getHouseId();
		House house = houseService.find(houseId);
		EssentialInfo essentialInfo = essentialInfoService.find(id);
		List<Room> roomList = roomService.find(id);
		List<Photo> photoList = shareHouse.getPhotos();
		model.addAttribute("house", house);
		model.addAttribute("shareHouse", shareHouse);
		model.addAttribute("essentialInfo", essentialInfo);
		model.addAttribute("roomList", roomList);
		model.addAttribute("photoList", photoList);
		return "/views/shareHouseModify.jsp";

	}

	@RequestMapping(value = "/shareHouse/shareHouseModify.do", method = RequestMethod.POST)
	public String modifyShareHouse(HttpSession session, String shareHouseId, String content, String title, ExtraInfo extraInfo,
			String buildingType, String parking, String floorTotalFloor, String lift, Room room,
			MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IOException {
		
		/* shareHouse modify */
		String memberId = (String) session.getAttribute("memberId");
		int id = Integer.parseInt(shareHouseId);
		ShareHouse shareHouse = shareHouseService.find(id);
		shareHouse.setWriterId(memberId);
		int houseId = Integer.parseInt(request.getParameter("houseId"));
		shareHouse.setHouseId(houseId);
		shareHouse.setContent(content);
		shareHouse.setTitle(title);
		shareHouseService.modify(shareHouse);

		/* room create */
		String[] provodedGood = request.getParameterValues("providedGood");
		List<String> providedGoods = new ArrayList<String>(Arrays.asList(provodedGood));
		String sex = request.getParameter("shareHouseGender");
		room.setSex(sex);
		room.setShareHouseId(id);
		roomService.register(room, providedGoods);

		/* extraInfo shareHouseId set */
		if (extraInfo.getPet() == null) {
			extraInfo.setPet("불가");
		}
		if (extraInfo.getSmoke() == null) {
			extraInfo.setSmoke("불가");
		}
		extraInfo.setShareHouseId(id);
		extraInfoService.register(extraInfo);

		/* essentialInfo create */
		EssentialInfo essentialInfo = new EssentialInfo();
		essentialInfo.setBuildingType(buildingType);
		essentialInfo.setFloorTotalFloor(floorTotalFloor);
		if (parking == null) {
			parking = "불가";
			essentialInfo.setParking(parking);
		} else {
			essentialInfo.setParking(parking);
		}
		if (lift == null) {
			lift = "없음";
			essentialInfo.setLift(lift);
		} else {
			essentialInfo.setLift(lift);
		}
		String[] publicUsage = request.getParameterValues("publicUsage");
		List<String> usages = new ArrayList<String>(Arrays.asList(publicUsage));
		essentialInfo.setShareHouseId(id);
		essentialInfoService.register(essentialInfo, usages);

		/* photo create */
		String realFolder = "c:/tempFiles/";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		List<MultipartFile> mf = mhsq.getFiles("photos");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				String genId = UUID.randomUUID().toString();
				String originFileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + originFileName;

				File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);
				byte[] bytes = mf.get(i).getBytes();
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();
				shareHouseService.savePhoto(saveFileName, shareHouse.getShareHouseId());
			}
		}

		return "/shareHouse/shareHouseDetail.do?shareHouseId=" + shareHouseId;
	}

	@RequestMapping(value = "/shareHouse/shareHouseDelete.do")
	public String removeShareHouse(String shareHouseId) {
		int id = Integer.parseInt(shareHouseId);

		shareHouseService.remove(id);
		essentialInfoService.deleteByShareHouse(id);
		extraInfoService.deleteByShareHouse(id);
		return "redirect:/shareHouseList.do";
	}

	@RequestMapping(value = "/shareHouse/shareHouseList.do")
	public String findAllShareHouse(Model model) {

		List<ShareHouse> shareHouses = shareHouseService.findAll();
		List<House> houses = houseService.findAll();

		List<String> list = new ArrayList<>();
		for (House house : houses) {
			list.add(house.getAddress());
		}

		int size = shareHouses.size();

		model.addAttribute("size", size);
		model.addAttribute("shareHouses", shareHouses);
		model.addAttribute("list", list);
		model.addAttribute("houses", houses);
		return "/views/shareHouseList.jsp";
	}

	@RequestMapping(value = "/shareHouse/shareHouseDetail.do")
	public String detailShareHouse(String shareHouseId, Model model) {
		int id = Integer.parseInt(shareHouseId);
		ShareHouse shareHouse = shareHouseService.find(id);
		EssentialInfo essentialInfo = essentialInfoService.find(id);
		ExtraInfo extraInfo = extraInfoService.find(id);
		List<Room> roomList = roomService.find(id);
		List<Review> reviews = reviewService.findByShareHouseId(id);
		House house = houseService.find(shareHouse.getHouseId());
		List<Photo> photos = shareHouse.getPhotos();

		model.addAttribute("photoList", photos);
		model.addAttribute("house", house);
		model.addAttribute("shareHouse", shareHouse);
		model.addAttribute("essentialInfo", essentialInfo);
		model.addAttribute("extraInfo", extraInfo);
		model.addAttribute("roomList", roomList);
		model.addAttribute("reviews", reviews);
		return "/views/shareHouseDetail.jsp";
	}

	@RequestMapping(value = "/myHouse.do", method = RequestMethod.GET)
	public String myHouse(Model model, HttpSession session) {
		String memberId = (String) session.getAttribute("memberId");
		List<ShareHouse> list = shareHouseService.findByMemberId(memberId);
		List<House> house = houseService.findAll();
		model.addAttribute("shareHouses", list);
		model.addAttribute("house", house);
		return "/views/myHouseList.jsp";
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	   public String index(Model model) {

	      List<ShareHouse> shareHouses = shareHouseService.findAll();
	      List<House> houses = houseService.findAll();
	      
	      List<ShareHouse> available = new ArrayList<>();
	      for(ShareHouse s : shareHouses) {
	         if(s.getRooms().get(0).getAvailability().equals("가능")) {
	            available.add(s);
	         }
	      }
	      model.addAttribute("shareHouses", available);
	      model.addAttribute("house", houses);
	      return "index.jsp";
	   }

}
