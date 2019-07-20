package com.niit.EcommFrontEnd.Controller;
import java.util.ArrayList;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcomBackend.DAO.CategoryDAO;
import com.niit.EcomBackend.Model.Category;
@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	CategoryDAO categorydao;
	@RequestMapping(value= {"/viewcategory"})
	public String categorypage(Model m) {
		m.addAttribute("categorymodel", new Category());
		m.addAttribute("categorylist", categorydao.selectAll());
		m.addAttribute("categorypage", true);
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		return "index";
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public String addcategory(@Valid @ModelAttribute("categorymodel") Category category, BindingResult br, Model m) {
		if (br.hasErrors()) {
			m.addAttribute("categorymodel", category);
			m.addAttribute("categorypage", true);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "please check your data");
			m.addAttribute("categorylist", categorydao.selectAll());
			return "index";
		} else {
			try {
				categorydao.insertorupdateCategory(category);
				return "redirect:/admin/viewcategory";
			} catch (Exception e) {
				m.addAttribute("categorymodel", category);
				m.addAttribute("categorypage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Data already present");
				m.addAttribute("categorylist", categorydao.selectAll());
				return "index";
			}
		}
	}
	@RequestMapping("/deletecat")
	String deletecatpage(@RequestParam("catname")String name,Model model)
	{
	categorydao.deleteCategory(categorydao.selectOne(name));
	return "redirect:/admin/viewcategory";
	}

	@RequestMapping("/editcat")
	String editcatpage(@RequestParam("catname")String name,Model model)
	{
	model.addAttribute("title","Category");
	model.addAttribute("categorypage",true);
	model.addAttribute("categorymodel",categorydao.selectOne(name));
	model.addAttribute("categorylist",categorydao.selectAll());
	model.addAttribute("haserror",false);
	model.addAttribute("error","");
	model.addAttribute("editmode",true);
	return "index";
	}
	@RequestMapping("/updatecat")
	String updatecatpage(@Valid @ModelAttribute("categorymodel")Category
	category,BindingResult bindingResult,Model model)
	{
	if(bindingResult.hasErrors())
	{
	model.addAttribute("title","Category");
	model.addAttribute("categorypage",true);
	model.addAttribute("categorymodel",category);
	model.addAttribute("categorylist",categorydao.selectAll());
	model.addAttribute("haserror",true);
	model.addAttribute("error","pls check ur data");
	model.addAttribute("editmode",true);
	return "index";
	}
	else
	{
	try
	{
	categorydao.insertorupdateCategory(category);
	return "redirect:/admin/viewcategory";
	}
	catch (Exception e)
	{
	model.addAttribute("title","Category");
	model.addAttribute("categorypage",true);
	model.addAttribute("categorymodel",category);
	model.addAttribute("categorylist",categorydao.selectAll());
	model.addAttribute("haserror",true);
	model.addAttribute("error","duplicate data");

	model.addAttribute("editmode",true);
	return "index";
	}
	}
	}
	}