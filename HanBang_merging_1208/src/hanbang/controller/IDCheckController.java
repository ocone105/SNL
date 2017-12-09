package hanbang.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hanbang.domain.Member;
import hanbang.service.MemberService;

@Controller
public class IDCheckController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberService service;

	@RequestMapping(value = "checkId.do", method = RequestMethod.POST)
	@ResponseBody
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		List<Member> members = service.findAll();

		String gotId = req.getParameter("id");
		PrintWriter out = response.getWriter();
		List<String> ids = new ArrayList<>();
		
		for (int i = 0; i < members.size(); i++) {
			String id = members.get(i).getId();
			ids.add(id);
		}
		System.out.println(ids.size());
		for (int j = 0; j < ids.size(); j++) {
			if (ids.get(j).equals(gotId)) {
				out.println("false");
			} else {
				out.println("ok");
			}
		}

	}
}
