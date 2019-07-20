//package com.niit.EcomBackend;
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//
//import com.niit.EcomBackend.DAO.CategoryDAO;
//import com.niit.EcomBackend.Model.Category;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Config.class)
//public class CategoryTestCase {
//	@Autowired
//	private CategoryDAO categorydao;
//	Category c;
//
//	@Before
//	public void setUp() throws Exception {
//		c = new Category();
//		c.setCategoryName("TITAN");
//		c.setCategoryDescription("ANALOG AND DIGITAL");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		categorydao.deleteCategory(c);
//	}
//
//	@Test
//	public void test() 
//	{
//		assertEquals("success", true, categorydao.insertorupdateCategory(c));
//	}
//	
//}
//
