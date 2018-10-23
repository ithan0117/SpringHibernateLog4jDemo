package _example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.member.pojo.MemberBean;
import web.member.service.MemberService;
import web.member.service.impl.MemberServiceImpl;

//@WebServlet("/member/findMemberByKey")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MemberService memberService = new MemberServiceImpl();
		Integer id = Integer.parseInt(request.getParameter("id"));
		MemberBean mb = memberService.selectMemberByKey(id);
		request.setAttribute("member", mb);
		request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
	}
}
