package com.tk.dao;

import java.util.List;

import com.tk.dao.hbm.Notice;

public interface NoticeDAO {
	
	public abstract void save(Notice notice);
	
	public abstract void delete(Notice notice);

	public abstract void update(Notice notice);
	
	public abstract List<Notice> findNoticesByDepartmentID(String departmentID);
}
