package com.niit.EcomBackend.DAO;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.EcomBackend.Model.UserDetails;
import com.niit.EcomBackend.Model.Usercredential;
@Repository
@Transactional
public class UserDetailsDAOImpl implements UserDetailsDAO{

	@Autowired
	SessionFactory sf;
	public boolean createUser(UserDetails userdetails) 
	{
			try
			{
				Usercredential usercredential=new Usercredential();
				usercredential.setEmailId(userdetails.getUseremailId());
				usercredential.setPassword(userdetails.getUserPassword());
				usercredential.setRole("ROLE_USER");
				usercredential.setStatus("true");
				sf.getCurrentSession().save(userdetails);
				sf.getCurrentSession().save(usercredential);
				return true;
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return false;
			}
	}
	

	public boolean updateUser(UserDetails userdetails) 
	{
				try
				{
					sf.getCurrentSession().update(userdetails);
					return true;
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return false;
				}
	}

	public boolean deleteUser(UserDetails userdetails) 
	{
				try
				{
					sf.getCurrentSession().delete(userdetails);
					sf.getCurrentSession().delete(userdetails.getUseremailId(), Usercredential.class);
					return true;
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return false;
				}
	}

	public UserDetails selectOneUser(String userdetailsEmailid) 
	{
				try
				{
					
					return (UserDetails)sf.getCurrentSession().createQuery("from UserDetails where useremailId='" + userdetailsEmailid + "'").uniqueResult();
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return null;
				}
	}

}
