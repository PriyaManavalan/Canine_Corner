package com.niit.EcomBackend.DAO;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.Product;

	@Repository
	@Transactional
	public class ProductDAOImpl implements ProductDAO {
		@Autowired
		SessionFactory sf;

		public boolean insertorupdateProduct(Product product)
		{
			try
			{
				sf.getCurrentSession().saveOrUpdate(product);
				return true;
			}
			catch (Exception e) 
			{
				return false;
			}
		}

		public boolean deleteProduct(Product product) {
			try
			{
				sf.getCurrentSession().delete(product);
				return true;
			}
			catch (Exception e) 
			{
				return false;
			}
		}

		public Product selectOne(String name) 
		{
			try
			{
				return (Product)sf.getCurrentSession().createQuery("from Product where productname ='"+name+"'").uniqueResult();
				 
			}
			catch (Exception e) 
			{
				return null;
			}
		}
	                	@SuppressWarnings("unchecked")
						public ArrayList<Product> selectAll() {
			try
			{
				return (ArrayList<Product>)sf.getCurrentSession().createQuery("from Product").list();
				 
			}
			catch (Exception e) 
			{
				return null;
			}
		}
}