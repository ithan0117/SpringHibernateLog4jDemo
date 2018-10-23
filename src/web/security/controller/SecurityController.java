package web.security.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("security")
public class SecurityController {

	@GetMapping("homePage")
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", getUsername());
		modelAndView.setViewName("security/homePage");
		return modelAndView;
	}
	
	@GetMapping(value = "login")
	public ModelAndView login(@RequestParam(value = "errorMsg", required = false) String errorMsg) {
		ModelAndView modelAndView = new ModelAndView();
		if (errorMsg != null) {
			modelAndView.addObject("errorMsg", "Invalid username and password!");
		}
		modelAndView.setViewName("security/login");
		return modelAndView;
	}
	
	@GetMapping("logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", "You've been logged out successfully.");
		modelAndView.setViewName("security/homePage");
		return modelAndView;
	}
	
	@GetMapping("403")
	public ModelAndView accesssDenied() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", getUsername());
		modelAndView.setViewName("security/403");
		return modelAndView;
	}
	
	private String getUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			return userDetail.getUsername();
		}
		return null;
	}
}
