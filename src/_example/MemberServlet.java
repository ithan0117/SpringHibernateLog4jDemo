package _example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.dao.MemberDaoImpl;
import member.model.pojo.MemberBean;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//@WebServlet("/member/findMemberByKey")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		MemberDao memberDAO = context.getBean(MemberDaoImpl.class);
		Integer id = Integer.parseInt(request.getParameter("id"));
		MemberBean mb = memberDAO.selectMemberByKey(id);
		request.setAttribute("member", mb);
		request.getRequestDispatcher("/pages/result.jsp").forward(request, response);
	}
}
