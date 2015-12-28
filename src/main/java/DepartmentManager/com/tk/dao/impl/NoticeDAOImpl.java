package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.NoticeDAO;
import com.tk.dao.hbm.Notice;

public class NoticeDAOImpl extends BaseDaoImpl implements NoticeDAO {

	@Override
	public void save(Notice notice) {
		try{
			getHibernateTemplate().save(notice);
		}catch(Exception e){
			System.out.println("Notice -> save exception: " + e);
		}
	}

	@Override
	public void delete(Notice notice) {
		try{
			getHibernateTemplate().delete(notice);
		}catch(Exception e){
			System.out.println("Notice -> delete exception: " + e);
		}
	}

	@Override
	public void update(Notice notice) {
		try{
			getHibernateTemplate().update(notice);
		}catch(Exception e){
			System.out.println("Notice -> update exception: " + e);
		}
	}

	@Override
	public List<Notice> findNoticesByDepartmentID(String departmentID) {
		try {
			List<Notice> list = getHibernateTemplate()
					.find("from com.tk.dao.hbm.Notice n where n.department.id = '" +departmentID+"'");
			return list;
		} catch (Exception e) {
			System.out.println("Notice -> findNoticesByDepartmentID exception: " + e);
			return null;
		}
		
	}

}
