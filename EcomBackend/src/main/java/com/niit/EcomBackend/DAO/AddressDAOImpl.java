package com.niit.EcomBackend.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.Address;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO
{
	@Autowired
	SessionFactory sf;
	
	public boolean createAddress(Address address) {
		try {
				sf.getCurrentSession().save(address);
				return true;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
	}
	
	
	public boolean updateAddress(Address address) {
		
		try {
				sf.getCurrentSession().update(address);
				return true;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return false;
			}
	}
	
	
		
	public boolean deleteAddress(Address address) {
		
		try {
			sf.getCurrentSession().delete(address);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
	
	public List<Address> selectAllAddress(int userId) {
		
		try {
				return sf.getCurrentSession().createQuery("from Address where user_userId="+userId).getResultList();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	

	public Address selectOneAddress(int addressId) {
		
		try {
				return (Address) sf.getCurrentSession().createQuery("from Address where addressId=" + addressId).uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
