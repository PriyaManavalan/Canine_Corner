package com.niit.EcommFrontEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcomBackend.DAO.CategoryDAO;
import com.niit.EcomBackend.DAO.ProductDAO;
import com.niit.EcomBackend.Model.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDAO productdao;
	@Autowired
	CategoryDAO categorydao;

	@RequestMapping(value = { "/", "/home" })
	public String homepage(Model m) {
		m.addAttribute("sliderpage", true);
		m.addAttribute("title", "cc-home");

		return "index";
	}

	@RequestMapping(value = { "/abtus" })
	public String aboutuspage(Model m) {
		m.addAttribute("aboutuspage", true);
		m.addAttribute("title", "cc-aboutus");

		return "index";
	}

	@RequestMapping(value = { "/contactus" })
	public String contactuspage(Model m) {
		m.addAttribute("contactuspage", true);
		m.addAttribute("title", "cc-contactus");

		return "index";
	}

	@RequestMapping(value = { "/login" })
	public String loginpage(Model m) {
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "cc-login");

		return "index";
	}

	@RequestMapping("/viewallproducts")
	public String viewallproduct(Model model) {
		model.addAttribute("productmodel", new Product());
		model.addAttribute("productlist", productdao.selectAll());
		model.addAttribute("viewallproducts", true);
		return "index";
	}

	@RequestMapping("/viewoneproduct")
	public String viewoneproduct(@RequestParam String name, Model model) {
		model.addAttribute("viewoneproduct", true);
		Product oneProduct = productdao.selectOne(name);
		model.addAttribute("product", oneProduct);
		return "index";
	}
	// @RequestMapping(value= {"/signup"})
	// public String signuppage(Model m)
	// {
	// m.addAttribute("signuppage",true);
	// m.addAttribute("title","cc-signup");
	//
	// return "index";
	// }
}