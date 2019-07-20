package com.niit.EcomBackend.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.MyOrder;

@Repository
@Transactional

public class MyOrderDAOImpl implements MyOrderDAO

{

	@Autowired
	SessionFactory sf;

	public boolean createOrder(MyOrder myorder) {
		try {
			sf.getCurrentSession().save(myorder);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateOrder(MyOrder myorder) {
		try {
			sf.getCurrentSession().update(myorder);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteOrder(MyOrder myorder) {
		try {
			sf.getCurrentSession().delete(myorder);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<MyOrder> selectAllOrder(int user_Id) {
		try {
			return sf.getCurrentSession().createQuery("from MyOrder where USER_USERID =" + user_Id).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public MyOrder selectOneOrder(String myorderId) {
		try {
			return (MyOrder) sf.getCurrentSession().createQuery("from MyOrder where orderId='" + myorderId+"'")
					.uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
