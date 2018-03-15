package member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import member.model.dao.MemberDao;
import member.model.pojo.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("memberRest")
public class MemberRestController {
	@Autowired
	private MemberDao memberDAO;

	@RequestMapping("restfulExample1")
	public MemberBean restfulExample1(@RequestParam(value = "id", required = true) int id) {
		return memberDAO.selectMemberByKey(id);
	}

	@RequestMapping("pathVariableExample/{id}")
	public MemberBean pathVariableExample(@PathVariable int id) {
		return memberDAO.selectMemberByKey(id);
	}

	@RequestMapping("restfulExample2")
	public List<MemberBean> restfulExample2() {
		return memberDAO.selectAllMembers();
	}
	
	@RequestMapping(value = "restfulGetImageExample", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageExample(HttpServletRequest request) {
		try {
			Path path = Paths.get(request.getServletContext().getRealPath("/static/image/image01.jpg"));
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
