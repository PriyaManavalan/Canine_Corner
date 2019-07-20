package com.niit.EcomBackend.DAO;
import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	SessionFactory sf;

	public boolean insertorupdateCategory(Category category) {
		try {
			sf.getCurrentSession().saveOrUpdate(category);
			System.out.println("df");
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public boolean deleteCategory(Category category) {
		try {
			sf.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Category selectOne(String name) {
		try {
			return (Category) sf.getCurrentSession().createQuery("from Category where categoryname = '" + name + "'")
					.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
	public ArrayList<Category> selectAll() {
		try {
			return (ArrayList<Category>) sf.getCurrentSession().createQuery("from Category").list();

		} catch (Exception e) {
			return null;
		}
	}
}