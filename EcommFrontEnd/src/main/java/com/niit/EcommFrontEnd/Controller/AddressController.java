package com.niit.EcommFrontEnd.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcomBackend.DAO.AddressDAO;
import com.niit.EcomBackend.DAO.UserDetailsDAO;

import com.niit.EcomBackend.Model.Address;

@Controller
@RequestMapping("/user")
public class AddressController 
{
	
	@Autowired
	AddressDAO addressdao;
	
	@Autowired
	UserDetailsDAO userdao;

	@RequestMapping("/address")
	String addressPage(Model model, HttpSession session) {
		model.addAttribute("addresspage", true);
		model.addAttribute("myaddress", new Address());
		model.addAttribute("Error1", false);
		model.addAttribute("Success", false);
		model.addAttribute("Error2", false);
		model.addAttribute("Error3", false);
		model.addAttribute("edit", false);
		model.addAttribute("addresslist",
		addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		return "index";
	}

	@RequestMapping("/addAddress")
	String insertAddressPage(@Valid @ModelAttribute("myaddress") Address address, BindingResult bindingResult,
			Model model, HttpSession session) {

		address.setUser(userdao.selectOneUser(session.getAttribute("useremailId").toString()));
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress", address);
			model.addAttribute("Error1", true);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("addresslist",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			model.addAttribute("Error3", false);
			model.addAttribute("edit", false);

		}

		else {
			try {
				if (addressdao.createAddress(address)) {
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", true);
					model.addAttribute("Error2", false);
					model.addAttribute("addresslist",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("Error3", false);
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", false);
					model.addAttribute("Error2", false);
					model.addAttribute("addresslist",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("Error3", true);
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("addresspage", true);
				model.addAttribute("myaddress", address);
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", true);
				model.addAttribute("addresslist",
						addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("Error3", false);
				model.addAttribute("edit", false);
			}

		}
		return "index";
	}

	@RequestMapping("/deleteAddress")
	String deleteAddressPage(@RequestParam("addressId") int addressId, Model model, HttpSession session) {
		try {
			if (addressdao.deleteAddress(addressdao.selectOneAddress(addressId)))
				return "redirect:/user/address";
			else {
				model.addAttribute("addresspage", true);
				model.addAttribute("myaddress", new Address());
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", false);
				model.addAttribute("addresslist",
						addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("Error3", true);
				model.addAttribute("edit", false);
				return "index";
			}

		} catch (Exception e) {
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress", new Address());
			model.addAttribute("Error1", false);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("addresslist",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			model.addAttribute("Error3", true);
			model.addAttribute("edit", false);
			return "index";

		}
	}

	@RequestMapping("/editAddress")
	String editAddressPage(@RequestParam("addressId") int addressId, Model model, HttpSession session) {
		model.addAttribute("addresspage", true);
		model.addAttribute("myaddress", addressdao.selectOneAddress(addressId));
		model.addAttribute("Error1", false);
		model.addAttribute("Success", false);
		model.addAttribute("Error2", false);
		model.addAttribute("addresslist",
				addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		model.addAttribute("Error3", false);
		model.addAttribute("edit", true);
		return "index";
	}

	@RequestMapping("/updateAddress")
	String updateAddressPage(@Valid @ModelAttribute("myaddress") Address address, BindingResult bindingResult,
			Model model, HttpSession session) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("addresspage", true);
			model.addAttribute("myaddress", address);
			model.addAttribute("Error1", true);
			model.addAttribute("Success", false);
			model.addAttribute("Error2", false);
			model.addAttribute("addresslist",
					addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			model.addAttribute("Error3", false);
			model.addAttribute("edit", false);

		}

		else {
			try {
				if (addressdao.updateAddress(address)) {
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", true);
					model.addAttribute("Error2", false);
					model.addAttribute("addresslist",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("Error3", false);
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("addresspage", true);
					model.addAttribute("myaddress", new Address());
					model.addAttribute("Error1", false);
					model.addAttribute("Success", false);
					model.addAttribute("Error2", false);
					model.addAttribute("addresslist",
							addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("Error3", true);
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("addresspage", true);
				model.addAttribute("myaddress", address);
				model.addAttribute("Error1", false);
				model.addAttribute("Success", false);
				model.addAttribute("Error2", true);
				model.addAttribute("addresslist",
				addressdao.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("Error3", false);
				model.addAttribute("edit", false);
			}

		}
		return "index";
	}

}
