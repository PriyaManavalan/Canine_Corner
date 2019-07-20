package com.niit.EcommFrontEnd.Controller;

import java.util.Iterator;
import java.util.List;

import javax.faces.render.FacesBehaviorRenderer;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcomBackend.DAO.CartDAO;
import com.niit.EcomBackend.DAO.ProductDAO;
import com.niit.EcomBackend.DAO.UserDetailsDAO;
import com.niit.EcomBackend.Model.Cart;
import com.niit.EcomBackend.Model.Category;
import com.niit.EcomBackend.Model.Product;

@Controller

public class CartController {

	@Autowired
	ProductDAO productdao;

	@Autowired
	UserDetailsDAO userdao;

	@Autowired
	CartDAO cartdao;

	@RequestMapping(value = { "/addtocart" })
	public String cartpage(@RequestParam("proname") String name,@RequestParam("quantity")int qty, Model m, HttpSession httpSession) {
		if (httpSession.getAttribute("usercartid") == null) {
			httpSession.setAttribute("proname", name);
			httpSession.setAttribute("quantity", qty);
			return "redirect:/Login";
		} else {
			List<Cart> cartitems = cartdao.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
			Iterator<Cart> iterator = cartitems.listIterator();
			Product prod = productdao.selectOne(name);
			while (iterator.hasNext()) {
				Cart cart = iterator.next();
				if (cart.getProduct().getProductid() == prod.getProductid()) {
					int nqty = cart.getQty() + qty;
					float tot = nqty * prod.getPrice();
					cart.setQty(qty);
					cart.setTotal(tot);
					cartdao.updateCart(cart);
					return "redirect:/cart";
				}
			}
			Cart c = new Cart();
			c.setUser(userdao.selectOneUser(httpSession.getAttribute("useremailId").toString()));
			c.setProduct(prod);
			c.setQty(qty);
			c.setTotal(qty*prod.getPrice());
			cartdao.createCart(c);
			return "redirect:/cart";			
		}
	}

	@RequestMapping(value = { "/cart" })
	public String viewcartpage(Model m, HttpSession session) {
		float tot = 0;

		List<Cart> cartitems = cartdao.selectAllCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Iterator<Cart> iterator = cartitems.listIterator();
		while (iterator.hasNext()) {
			Cart cart = (Cart) iterator.next();
			tot = tot + cart.getTotal();
		}
		m.addAttribute("cartpage", true);
		m.addAttribute("cartitems", cartitems);
		session.setAttribute("shipping", cartitems.size() * 50);
		session.setAttribute("tot", tot + cartitems.size() * 50);
		session.setAttribute("itemcount", cartitems.size());

		return "index";

	}

	@RequestMapping("/deletecart")
	String deletecart(@RequestParam("cartId") int cart_id) {
		cartdao.deleteCart(cartdao.selectOneCart(cart_id));
		return "redirect:/cart";

	}
}