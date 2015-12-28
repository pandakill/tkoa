package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.UsersDAO;
import com.tk.dao.hbm.Users;

public class UsersImpl extends BaseDaoImpl implements UsersDAO {

	@Override
	public void save(Users users) {
		try {
			getHibernateTemplate().save(users);
		} catch (Exception e) {
			System.out.println("UsersImpl -> save exception: " + e);
		}
	}

	@Override
	public void update(Users users) {
		try{
			getHibernateTemplate().update(users);
		}catch (Exception e){
			System.out.println("UsersImpl -> update exception: " + e);
		}
	}

	@Override
	public void delete(Users users) {
		try{
			getHibernateTemplate().delete(users);
		}catch (Exception e){
			System.out.println("UsersImpl -> delete exception: " + e);
		}
	}

	@Override
	public Users findByUserName(String username) {
		try{
			Users users = new Users();
			users = (Users) getHibernateTemplate().get("com.tk.dao.hbm.Users", username);
			return users;
		}catch (Exception e){
			System.out.println("UsersImpl -> fundByUserName exception: " + e);
			return null;
		}
	}

	@Override
	public List<Users> findAll() {
		try{
			List<Users> list = getHibernateTemplate().find("from com.tk.dao.hbm.Users");
			return list;
		}catch (Exception e){
			System.out.println("UsersImpl -> findAll exception: " + e);
			return null;
		}
	}

}
