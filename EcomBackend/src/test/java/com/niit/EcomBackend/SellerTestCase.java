///*package com.niit.EcomBackend;
//
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
//import com.niit.EcomBackend.DAO.SellerDAO;
//import com.niit.EcomBackend.Model.Seller;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=Config.class)
//public class SellerTestCase 
//{
//	@Autowired
//	private SellerDAO sellerdao;
//	Seller s;
//	public  Seller getEmailid()
//	{
//		return s ;
//		
//	}
//	public Seller getplace()
//	{
//		return s;
//		
//	}
//	public Seller getPhno()
//	{
//		return s;
//	}
//	@Before
//	public void setUp() throws Exception {
//		s = new Seller();
//	
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		sellerdao.deleteSeller(s);
//		
//	}
//
//	@Test
//	public void test() {
//		assertEquals("success", true,sellerdao.insertorupdateSeller(s));
//	}
//
//}
//*/