package com.niit.EcomBackend.DAO;

import com.niit.EcomBackend.Model.UserDetails;

public interface UserDetailsDAO {

	boolean createUser(UserDetails userdetails);

	boolean updateUser(UserDetails userdetails);

	boolean deleteUser(UserDetails userdetails);

	UserDetails selectOneUser(String userdetailsEmailid);
}
