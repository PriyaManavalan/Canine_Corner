package com.niit.EcomBackend.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sf;

	public boolean createCart(Cart cart) {
		try {
			sf.getCurrentSession().save(cart);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean updateCart(Cart cart) {
		
		try {
			sf.getCurrentSession().update(cart);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteCart(Cart cart) {
		

		try {
			sf.getCurrentSession().delete(cart);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Cart> selectAllCart(int userId) {
		
		List<Cart> cartlist=new ArrayList<Cart>();
		try {
			cartlist=sf.getCurrentSession().createQuery("from Cart where user_userId=" + userId).list();
			return cartlist;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return cartlist;
		}
	}

	public Cart selectOneCart(int itemId) {
	
		try {
			return (Cart) sf.getCurrentSession().createQuery("from Cart where cartId=" + itemId)
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
