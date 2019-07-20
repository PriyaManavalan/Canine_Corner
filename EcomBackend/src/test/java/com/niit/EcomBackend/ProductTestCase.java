///*package com.niit.EcomBackend;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.niit.EcomBackend.DAO.ProductDAO;
//import com.niit.EcomBackend.Model.Product;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Config.class)
//public class ProductTestCase {
//	@Autowired
//	private ProductDAO productdao;
//	Product p;
//	@Before
//	public void setUp() throws Exception {
//		p = new Product();
//		p.setProductName("fastrack watches");
//		p.setProductDescription("mens watch");
//		p.setQuantity(1);
//		p.setPrice("3500");
//	}
//	@After
//	public void tearDown() throws Exception {
//		productdao.deleteProduct(p);
//	}
//	@Test
//	public void test() {
//		assertEquals("success", true, productdao.insertorupdateProduct(p));
//	}
//}
//
//	
//*/