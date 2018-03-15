package controller;

import model.dao.IMemberDAO;
import model.pojo.MemberBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//4.2.1宣告成控制器類別
@RequestMapping("member")//4.2.2設定此控制器映射的根URL路徑
public class MemberController {
	@Autowired
	private IMemberDAO memberDAO;//變數名稱需與Hibernate步驟7中交給Spring-Core管理的物件名稱(黑底)相同
	
	@RequestMapping(value = "findMemberByKey", method = RequestMethod.POST)//6.1設定URL路徑及請求方法
	public String findMemberByKey(Model model, Integer id) {//6.2宣告請求參數註10
		MemberBean mb = memberDAO.selectMemberByKey(id);
		model.addAttribute("member", mb);//6.3儲存屬性物件
										 //Model物件類似Servlet裡的HttpServletRequest物件, 用來儲存屬性物件
		return "result";//6.4回傳View名稱註11
	}

}

