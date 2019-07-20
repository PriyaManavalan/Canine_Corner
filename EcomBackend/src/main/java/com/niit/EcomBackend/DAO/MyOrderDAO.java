package com.niit.EcomBackend.DAO;

import java.util.List;

import com.niit.EcomBackend.Model.MyOrder;

public interface MyOrderDAO
{

	boolean createOrder(MyOrder myorder);

	boolean updateOrder(MyOrder myorder);

	boolean deleteOrder(MyOrder myorder);

	List<MyOrder> selectAllOrder(int userId);

	MyOrder selectOneOrder(String myorderId);
}
