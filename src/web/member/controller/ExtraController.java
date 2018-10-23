package web.member.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import web.member.pojo.MemberBean;

@Controller
@RequestMapping("extra")
public class ExtraController {

	@RequestMapping(value = "getImageExample", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageExample(HttpServletRequest request) {
		try {
			Path path = Paths.get(request.getServletContext().getRealPath("/static/images/image01.jpg"));
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("redirectExmaple1")
	public RedirectView redirectExample1(HttpSession session) {
		System.out.println("redirectExmaple1");
		session.setAttribute("message", "redirectExmaple1");
		return new RedirectView("../pages/result.jsp");
	}

	@RequestMapping("redirectExample2")
	public String redirectExample2(HttpSession session) {
		System.out.println("redirectExample2");
		session.setAttribute("message", "redirectExmaple2");
		return "redirect:../pages/result.jsp";
	}
	
	@RequestMapping("forwardExample")
	public String forwardExample(Model model) {
		System.out.println("forwardExample");
		model.addAttribute("message", "forwardExample");
		return "forward:/pages/result.jsp";
	}
	
	@RequestMapping("modelAndViewExample")
	public ModelAndView modelAndViewExample() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("result");
		modelAndView.addObject("message", "modelAndViewExample");
		return modelAndView;
	}

	@RequestMapping(value = "autoBoxingExample", method = RequestMethod.POST)
	public String autoBoxingExample(Model model, MemberBean memberBean) {
		model.addAttribute("message", "autoBoxingExample");
		model.addAttribute("member", memberBean);
		return "result";
	}

	@InitBinder
	public void dateBinderInit(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping("sendParameterByMapType")
	public String sendParameterByMapType(Map<String, Object> map) {
		map.put("message", "sendParameterByMapType");
		MemberBean memberBean = new MemberBean();
		map.put("member", memberBean);
		memberBean.setId(1);
		memberBean.setAccount("account");
		memberBean.setPassword("password");
		memberBean.setNickname("nickname");
		memberBean.setCreateTime(new Timestamp(System.currentTimeMillis()));
		memberBean.setPass(true);
		memberBean.setSessionId("sessionId");
		return "result";
	}

	@RequestMapping(value = "uploadFileExample", method = RequestMethod.POST)
	public String uploadFileExample(Model model, @RequestParam("files") MultipartFile[] files) {
		StringBuilder resultMessage = new StringBuilder();
		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			try {
				Files.write(Paths.get("D:\\", fileName), file.getBytes());//D:\\為寫出檔案的路徑
				resultMessage.append(fileName + " upload success<br>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("message", resultMessage);
		return "result";
	}

	@ExceptionHandler(Throwable.class)//設定欲處理的例外類別
	public void exceptionHandlerExample2(Throwable t) {
		System.out.println("exceptionHandlerExample2 : " + t.getClass().getSimpleName());
	}
	
	private final static Logger logger = Logger.getLogger(MemberController.class);
	
	@RequestMapping("log4jExample")
	public String log4jExample(Model model) {
		model.addAttribute("message", "log4jExample");
		//4.2輸出log
		logger.trace("message");
		logger.debug("message");
		logger.info("message");
		logger.warn("message");
		logger.error("message");
		logger.fatal("message");
		return "result";
	}

	@RequestMapping("exceptionTest")
	public String exceptionTest() {
		int i = 1 / 0;//故意產生的例外
		return "result";
	}
}
