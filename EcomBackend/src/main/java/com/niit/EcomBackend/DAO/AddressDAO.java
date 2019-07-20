package com.niit.EcomBackend.DAO;

import java.util.List;

import com.niit.EcomBackend.Model.Address;

public interface AddressDAO
{

boolean createAddress(Address address);
	
	boolean updateAddress(Address address);
	
	boolean deleteAddress(Address address);
	
	List<Address> selectAllAddress(int userId);
	
	Address selectOneAddress(int addressId);
}
