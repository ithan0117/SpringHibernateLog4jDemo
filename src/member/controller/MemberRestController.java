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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@CrossOrigin(origins = "http://localhost:63342")//CORS support
	@RequestMapping(value = "restfulGetImageExample", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageExample(HttpServletRequest request) {
		try {
			Path path = Paths.get(request.getServletContext().getRealPath("/static/images/image01.jpg"));
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "receiveRequestParamsWithJsonFormat", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String receiveRequestParamsWithJsonFormat(@RequestBody MemberBean member) {
		System.out.println("id : " + member.getId());
		System.out.println("account : " + member.getAccount());
		System.out.println("password : " + member.getPassword());
		System.out.println("nickname : " + member.getNickname());
		System.out.println("createTime : " + member.getCreateTime());
		System.out.println("pass : " + member.getPass());
		System.out.println("sessionId : " + member.getSessionId());
		return "success";
	}
}
