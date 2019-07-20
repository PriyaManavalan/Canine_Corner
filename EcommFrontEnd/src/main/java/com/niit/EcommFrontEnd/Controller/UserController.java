package com.niit.EcommFrontEnd.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.EcomBackend.DAO.UserDetailsDAO;
import com.niit.EcomBackend.Model.UserDetails;

@Controller
public class UserController {
	    
	    @Autowired
	    UserDetailsDAO userdao;
	    
	    @RequestMapping("/signup")
	    public String registerpage(Model model)
	    {
	        model.addAttribute("registerpage",true);
	        model.addAttribute("usermodel",new UserDetails());
	        model.addAttribute("haserror", false);
            model.addAttribute("error", " ");
	        return "index";
	    }
	   
	    @RequestMapping(value="/createUser",method=RequestMethod.POST)
	    public String createUser(@Valid @ModelAttribute("usermodel") UserDetails user,BindingResult br,Model m)
	    {
	        if(br.hasErrors())
	        {
	           
	            m.addAttribute("usermodel",user);
	            m.addAttribute("registerpage",true);
				m.addAttribute("usermodel", user);
	            m.addAttribute("haserror",true);
	            m.addAttribute("error", "Please check ur data");
	            return "index";
	        }
        
	        else 
	        {
	            try
	            {
	            	userdao.createUser(user);
	                return "redirect:/signup";        
	            }
	            catch(Exception e)
	            {
	                m.addAttribute("usermodel",user);
	                m.addAttribute("registerpage",true);
	                m.addAttribute("haserror", true);
	                m.addAttribute("error", "Already Data Present");
	                return "index";
	            }
	        }
	    }
}