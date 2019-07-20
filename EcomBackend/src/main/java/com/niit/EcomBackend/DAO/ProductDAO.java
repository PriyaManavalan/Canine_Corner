package com.niit.EcomBackend.DAO;

import java.util.ArrayList;

import com.niit.EcomBackend.Model.Product;



public interface ProductDAO
{
	public boolean insertorupdateProduct(Product product );
	public boolean deleteProduct(Product product);
	public Product selectOne(String name);
	public ArrayList<Product> selectAll();
}
