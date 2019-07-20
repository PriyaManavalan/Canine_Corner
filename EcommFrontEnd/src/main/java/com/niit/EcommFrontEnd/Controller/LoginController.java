package com.niit.EcommFrontEnd.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.EcomBackend.DAO.UserDetailsDAO;
import com.niit.EcomBackend.Model.UserDetails;

@Controller
public class LoginController {
	@Autowired
	UserDetailsDAO userdao;

	@RequestMapping(value = { "/logout" })
	public String logoutpage(Model model,HttpSession httpSession) {
		httpSession.invalidate();
		model.addAttribute("sliderpage", true);
		model.addAttribute("title", "Canine Corner-Logout");
		return "index";

	}

	@RequestMapping(value = { "/Login" })
	public String loginpage(Model model) {
		model.addAttribute("error", false);
		model.addAttribute("loginpage", true);
		model.addAttribute("title", "Canine Corner-Login");
		return "index";

	}

	@RequestMapping(value = { "/flogin" })
	public String errorloginpage(Model model) {
		model.addAttribute("error", true);
		model.addAttribute("messgae", "");
		model.addAttribute("loginpage", true);
		model.addAttribute("title", "Canine Corner-Login");
		return "index";
	}

	@RequestMapping(value = { "/loginsuccess" })
	public String loginsuccess(HttpSession session, Model model) {
		String emailId = SecurityContextHolder.getContext().getAuthentication().getName();
		if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_ADMIN]")) {
			session.setAttribute("usrename", "Administrator");
			session.setAttribute("adminlogin", true);
			
			return "redirect:/";
		} else {
			UserDetails user = userdao.selectOneUser(emailId);
			session.setAttribute("useremailId", user.getUseremailId());
			session.setAttribute("usercartid", user.getUserId());
			session.setAttribute("username", user.getUserName());
			session.setAttribute("userlogin", true);
			if (session.getAttribute("proname") != null) {
				String id=session.getAttribute("proname").toString();
				int qty=Integer.parseInt(session.getAttribute("quantity").toString());
				return "redirect:/addtocart?proname="+id+"&quantity="+qty;
			} else {
				return "redirect:/";
			}

		}
	}

}
