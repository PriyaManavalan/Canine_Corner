package com.niit.EcommFrontEnd.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EcomBackend.DAO.AddressDAO;
import com.niit.EcomBackend.DAO.CartDAO;
import com.niit.EcomBackend.DAO.MyOrderDAO;
import com.niit.EcomBackend.DAO.ProductDAO;
import com.niit.EcomBackend.DAO.UserDetailsDAO;
import com.niit.EcomBackend.Model.Cart;
import com.niit.EcomBackend.Model.MyOrder;
import com.niit.EcomBackend.Model.Product;

@Controller 
public class OrderController
{

	
	@Autowired
	CartDAO cartdao;

	@Autowired
	AddressDAO adddao;

	@Autowired
	UserDetailsDAO userdao;

	@Autowired
	ProductDAO prodao;

	@Autowired
	MyOrderDAO myorderdao;

	@RequestMapping("/user/placeorder")
	String placeOrder(@RequestParam("addressId") int addressId, Model model, HttpSession httpSession)
	{
		MyOrder myorder = new MyOrder();
		ArrayList<Cart> carts = (ArrayList<Cart>) cartdao
				.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
		Iterator<Cart> iterator = carts.iterator();
		while (iterator.hasNext())
		{
			Date d = new Date();
			long id = UUID.randomUUID().getMostSignificantBits();
			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));
			Cart cart = (Cart) iterator.next();
			Product p=prodao.selectOne(cart.getProduct().getProductname());
			if (p.getQuantity() >= cart.getQty()); 
			{
				myorder.setAddress(adddao.selectOneAddress(addressId));
				myorder.setOrderId(oid);
				myorder.setOrderDate(d);
				myorder.setQuantity(cart.getQty());
				myorder.setProduct(cart.getProduct());
				myorder.setGrandTotal(cart.getTotal());
				myorder.setUser(userdao.selectOneUser(httpSession.getAttribute("useremailId").toString()));
				int qty=p.getQuantity() - cart.getQty();
				p.setQuantity(qty);
					if(myorderdao.createOrder(myorder))
					{
					prodao.insertorupdateProduct(p);
					cartdao.deleteCart(cart);
					}
			}
		}
		
		ArrayList<Cart> cartitems = (ArrayList<Cart>) cartdao.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
		httpSession.setAttribute("itemcount", cartitems.size());
		model.addAttribute("orderlist", myorderdao.selectAllOrder(Integer.parseInt(httpSession.getAttribute("usercartid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}
	
		@RequestMapping("/user/vieworders")
		String viewallorders(Model model,HttpSession httpSession)
		
	{
		model.addAttribute("orderlist", myorderdao.selectAllOrder(Integer.parseInt(httpSession.getAttribute("usercartid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}
	
	@RequestMapping("/user/receipt")
	String receipt(@RequestParam("myorderId")String myorderId,Model model,HttpSession httpSession)
	
	{
		model.addAttribute("order", myorderdao.selectOneOrder(myorderId));
		model.addAttribute("receiptpage", true);
		return "index";
		
	}

}