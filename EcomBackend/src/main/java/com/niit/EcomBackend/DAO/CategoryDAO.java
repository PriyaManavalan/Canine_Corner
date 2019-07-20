package com.niit.EcomBackend.DAO;
import java.util.ArrayList;


import com.niit.EcomBackend.Model.Category;

public interface CategoryDAO 
{
	public boolean insertorupdateCategory(Category category );
	public boolean deleteCategory(Category category);
	public Category selectOne(String name);
	public ArrayList<Category> selectAll();
	
}
