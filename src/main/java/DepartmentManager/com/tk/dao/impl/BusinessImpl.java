package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.BusinessDAO;
import com.tk.dao.hbm.Business;

public class BusinessImpl extends BaseDaoImpl implements BusinessDAO {

	@Override
	public void save(Business business) {
		try {
			getHibernateTemplate().save(business);
		} catch (Exception e) {
			System.out.println("BusinessImpl -> save exception:" + e);
		}
	}

	@Override
	public void update(Business business) {
		try {
			getHibernateTemplate().update(business);
		} catch (Exception e) {
			System.out.println("BusinessImpl -> update exception:" + e);
		}
	}

	@Override
	public void delete(Business business) {
		try {
			getHibernateTemplate().delete(business);
		} catch (Exception e) {
			System.out.println("BusinessImpl -> delete exception:" + e);
		}
	}

	@Override
	public Business findByID(int id) {
		try {
			Business business = new Business();
			business = (Business) getHibernateTemplate().get("com.tk.dao.hbm.Business", id);
			return business;
		} catch (Exception e) {
			System.out.println("BusinessImpl -> findByID exception:" + e);
			return null;
		}
	}

	@Override
	public List<Business> findAll() {
		try {
			List<Business> list = getHibernateTemplate().find("from com.tk.dao.hbm.Business");
			return list;
		} catch (Exception e) {
			System.out.println("BusinessImpl -> findAll exception:" + e);
			return null;
		}
	}

	@Override
	public Business findByName(String name) {
		try {
			List<Business> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Business b where b.name = '" + name + "'");
			Business business = null;
			if( null != list){
				business = (Business)list.get(0);
			}
			return business;
		} catch (Exception e) {
			System.out.println("BusinessImpl -> findByName exception:" + e);
			return null;
		}
	}

}
