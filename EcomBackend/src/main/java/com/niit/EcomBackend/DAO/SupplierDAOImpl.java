package com.niit.EcomBackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.Supplier;
import com.niit.EcomBackend.Model.Usercredential;
@Repository
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sf;
	public boolean createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			Usercredential usercredential=new Usercredential();
			usercredential.setEmailId(supplier.getSupplierEmailid());
			usercredential.setPassword(supplier.getSupplierEmailid());
			usercredential.setRole("Role_Admin");
			usercredential.setStatus("true");
			sf.getCurrentSession().save(supplier);
			sf.getCurrentSession().save(usercredential);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean updateSupplier(Supplier supplier) {
		try {
			sf.getCurrentSession().update(supplier);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sf.getCurrentSession().delete(supplier);
			sf.getCurrentSession().delete(supplier.getSupplierEmailid(),Usercredential.class);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Supplier> selectAllSupplier() {
		try {
			return sf.getCurrentSession().createQuery("from Supplier").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Supplier selectOneSupplier(String emailId) {
		try {
			return (Supplier) sf.getCurrentSession()
					.createQuery("from Supplier where supplier_Id=" + emailId).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
