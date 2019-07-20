package com.niit.EcommFrontEnd.Controller;
	import java.io.BufferedOutputStream;
	import java.io.File;
	import java.io.FileOutputStream;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.multipart.MultipartFile;

import com.niit.EcomBackend.DAO.CategoryDAO;
import com.niit.EcomBackend.DAO.ProductDAO;
import com.niit.EcomBackend.Model.Product;

	@Controller
	@RequestMapping("/admin")
	public class ProductController {
		@Autowired
		ProductDAO productdao;
		@Autowired
		CategoryDAO categorydao;
		void fileupload(MultipartFile f, int pi) {
			try {
				String path = "E:\\EcommFrontEnd\\src\\main\\webapp\\resources\\pimages\\";
				path = path + String.valueOf(pi) + ".jpg";
				if (f != null) {
					byte[] b = f.getBytes();
					File newfile = new File(path);
					if (newfile.exists()) {
						newfile.delete();
						BufferedOutputStream b1 = new BufferedOutputStream(new FileOutputStream(newfile));
						b1.write(b);
						b1.close();
					} else {
						BufferedOutputStream b1 = new BufferedOutputStream(new FileOutputStream(newfile));
						b1.write(b);
						b1.close();
					}
				}
			} catch (Exception e) {
			}
		}
		@RequestMapping("/viewproduct")
		public String indexpage(Model m) {
			m.addAttribute("productmodel", new Product());
			m.addAttribute("productlist", productdao.selectAll());
			m.addAttribute("categorylist",categorydao.selectAll());
			m.addAttribute("productpage", true);
			m.addAttribute("haserror", false);
			m.addAttribute("error", "");
			m.addAttribute("editmode", false);
			return "index";
		}
		@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
		public String addcategory(@Valid @ModelAttribute("productmodel") Product product, BindingResult br, Model m) {
			if (br.hasErrors()) {
				m.addAttribute("productmodel", product);
				m.addAttribute("productpage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "please check ur data");
				m.addAttribute("productlist", productdao.selectAll());
				m.addAttribute("categorylist", categorydao.selectAll());
				m.addAttribute("editmode", false);
				System.out.println(br.toString());
				return "index";

			} 
			else {
				try {
					if (productdao.insertorupdateProduct(product))
						fileupload(product.getProductimage(), product.getProductid());
					return "redirect:/admin/viewproduct";

				} catch (Exception e) {
					m.addAttribute("productmodel", product);
					m.addAttribute("productpage", true);
					m.addAttribute("haserror", true);
					m.addAttribute("error", "Data Already Present");
					m.addAttribute("productlist", productdao.selectAll());
					m.addAttribute("categorylist", categorydao.selectAll());
					m.addAttribute("editmode", false);
				}
			}
				return "index";
		}
		@RequestMapping("/deletepro")
		String delproductpage(@RequestParam("productname") String name, Model model) {
			// use this if ur delete category method has name or id
			// catdao.deleteCategory(name);

			// use this if ur delete category method has Category as it parameter
			productdao.deleteProduct(productdao.selectOne(name));
			return "redirect:/admin/viewproduct";
		}
		@RequestMapping("/editpro")
		String editproductpage(@RequestParam("productname") String name, Model model) {
			model.addAttribute("title", "Product");
			model.addAttribute("productpage", true);
			model.addAttribute("productmodel", productdao.selectOne(name));
			model.addAttribute("productlist", productdao.selectAll());
			model.addAttribute("categorylist", categorydao.selectAll());
			model.addAttribute("haserror", false);
			model.addAttribute("error", "");
			model.addAttribute("editmode", true);
			return "index";
		}
		@RequestMapping(value = "/updatepro", method = RequestMethod.POST)
		public String updateProduct(@Valid @ModelAttribute("productmodel") Product product, BindingResult br, Model m) {
			if (br.hasErrors()) {
				m.addAttribute("productmodel", product);
				m.addAttribute("productpage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "please check ur data");
				m.addAttribute("productlist", productdao.selectAll());
				m.addAttribute("categorylist", categorydao.selectAll());
				m.addAttribute("editmode", true);
				return "index";
			}
			else 
			{
				try {
					if(productdao.insertorupdateProduct(product))
						fileupload(product.getProductimage(),product.getProductid());
					return "redirect:/admin/viewproduct";
				}
				catch (Exception e) 
				{
					m.addAttribute("productmodel", product);
					m.addAttribute("productpage", true);
					m.addAttribute("haserror", true);
					m.addAttribute("error", "Data Already Present");
					m.addAttribute("productlist", productdao.selectAll());
					m.addAttribute("categorylist", categorydao.selectAll());
					m.addAttribute("editmode", true);
				}
			}
			return "index";
			
		}
	}