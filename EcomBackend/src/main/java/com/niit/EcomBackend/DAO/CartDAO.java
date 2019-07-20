package com.niit.EcomBackend.DAO;

import java.util.List;

import com.niit.EcomBackend.Model.Cart;

public interface CartDAO {
	
	boolean createCart(Cart cart);
	
	boolean updateCart(Cart cart);
	
	boolean deleteCart(Cart cart);
	
	List<Cart> selectAllCart(int userId);
	
	Cart selectOneCart(int itemId);

}
