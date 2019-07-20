//package com.niit.EcommFrontEnd.Controller;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.niit.EcomBackend.DAO.SupplierDAO;
//import com.niit.EcomBackend.Model.Supplier;
//
//@Controller
//public class SupplierController {
//	@Autowired
//	SupplierDAO supplierDAO;
//	@RequestMapping("/registersupplier")
//	String product(Model model) {
//		model.addAttribute("supplier", true);
//		model.addAttribute("mysupplier", new Supplier());
//		model.addAttribute("error1", false);
//		model.addAttribute("success", false);
//		model.addAttribute("error2", false);
//		model.addAttribute("fail", false);
//		model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//		model.addAttribute("edit", false);
//
//		return "index";
//	}
//
//	@RequestMapping("/addSupplier")
//	String insertproduct(@Valid @ModelAttribute("mysupplier") Supplier s, BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) 
//		{
//			System.out.println(bindingResult.toString());
//			model.addAttribute("supplier", true);
//			model.addAttribute("mysupplier", s);
//			model.addAttribute("error1", true);
//			model.addAttribute("success", false);
//			model.addAttribute("error2", false);
//			model.addAttribute("fail", false);
//			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//			model.addAttribute("edit", false);
//		} 
//		else 
//		{
//			try 
//			{
//				if (supplierDAO.createSupplier(s)) 
//				{
////					addimage(p.getProduct_Image(), s.getSupplier_Id());
//					model.addAttribute("supplier", true);
//					model.addAttribute("mysupplier", new Supplier());
//					model.addAttribute("error1", false);
//					model.addAttribute("success", true);
//					model.addAttribute("error2", false);
//					model.addAttribute("fail", false);
//					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//					model.addAttribute("edit", false);
//				} else {
//					model.addAttribute("supplier", true);
//					model.addAttribute("mysupplier", new Supplier());
//					model.addAttribute("error1", false);
//					model.addAttribute("success", false);
//					model.addAttribute("error2", false);
//					model.addAttribute("fail", true);
//					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//					model.addAttribute("edit", false);
//				}
//			} catch (Exception e) {
//				model.addAttribute("supplier", true);
//				model.addAttribute("mysupplier", s);
//				model.addAttribute("error1", false);
//				model.addAttribute("error2", true);
//				model.addAttribute("success", false);
//				model.addAttribute("fail", false);
//				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//				model.addAttribute("edit", false);
//			}
//		}
//
//		return "index";
//	}
//
//	@RequestMapping("/updateSupplier")
//	String updateproduct(@Valid @ModelAttribute("mysupplier") Supplier s, BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) {
//			System.out.println(bindingResult.toString());
//			model.addAttribute("supplier", true);
//			model.addAttribute("mysupplier", s);
//			model.addAttribute("error1", true);
//			model.addAttribute("success", false);
//			model.addAttribute("error2", false);
//			model.addAttribute("fail", false);
//			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//			model.addAttribute("edit", true);
//		} 
//		else 
//		{
//			try 
//			{
//				if (supplierDAO.updateSupplier(s)) 
//				{
////					addimage(s.getProduct_Image(), s.getSupplier_Id());
//					model.addAttribute("supplier", true);
//					model.addAttribute("mysupplier", new Supplier());
//					model.addAttribute("error1", false);
//					model.addAttribute("success", true);
//					model.addAttribute("error2", false);
//					model.addAttribute("fail", false);
//					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//					model.addAttribute("edit", false);
//				} else {
//					model.addAttribute("supplier", true);
//					model.addAttribute("mysupplier", s);
//					model.addAttribute("error1", false);
//					model.addAttribute("success", false);
//					model.addAttribute("error2", false);
//					model.addAttribute("fail", true);
//					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//					model.addAttribute("edit", true);
//				}
//			} catch (Exception e) {
//				model.addAttribute("supplier", true);
//				model.addAttribute("mysupplier", s);
//				model.addAttribute("error1", false);
//				model.addAttribute("error2", true);
//				model.addAttribute("success", false);
//				model.addAttribute("fail", false);
//				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//				model.addAttribute("edit", true);
//			}
//		}
//
//		return "index";
//	}
//
//	@RequestMapping("/deleteSupplier")
//	String deleteproduct(@RequestParam("supid") String supplier_Email, Model model) {
//		try {
//			if (supplierDAO.deleteSupplier(supplierDAO.selectOneSupplier(supplier_Email)))
//				return "redirect:/supplier";
//			else {
//				model.addAttribute("supplier", true);
//				model.addAttribute("mysupplier", new Supplier());
//				model.addAttribute("error1", false);
//				model.addAttribute("success", false);
//				model.addAttribute("error2", false);
//				model.addAttribute("fail", true);
//				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//				model.addAttribute("edit", false);
//				return "index";
//			}
//
//		} catch (Exception e) {
//			model.addAttribute("supplier", true);
//			model.addAttribute("mysupplier", new Supplier());
//			model.addAttribute("error1", false);
//			model.addAttribute("success", false);
//			model.addAttribute("error2", false);
//			model.addAttribute("fail", true);
//			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//			model.addAttribute("edit", false);
//			return "index";
//		}
//	}
//
//	@RequestMapping("/editSupplier")
//	String editproduct(@RequestParam("supid") String supplier_Email, Model model) {
//		model.addAttribute("supplier", true);
//		model.addAttribute("mysupplier", supplierDAO.selectOneSupplier(supplier_Email));
//		model.addAttribute("suplist", supplierDAO.selectAllSupplier());
//		model.addAttribute("error1", false);
//		model.addAttribute("success", false);
//		model.addAttribute("error2", false);
//		model.addAttribute("fail", false);
//		model.addAttribute("edit", true);
//		return "index";
//	}
//
//}
