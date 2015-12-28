package com.tk.dao.impl;

import java.util.List;

import com.tk.dao.PostDAO;
import com.tk.dao.hbm.Post;

public class PostImpl extends BaseDaoImpl implements PostDAO {

	@Override
	public void save(Post post) {
		try {
			getHibernateTemplate().save(post);
		} catch (Exception e) {
			System.out.println("PostImpl -> save exception:");
		}
	}

	@Override
	public void update(Post post) {
		try {
			getHibernateTemplate().update(post);
		} catch (Exception e) {
			System.out.println("PostImpl -> update exception:");
		}
	}

	@Override
	public void delete(Post post) {
		try {
			getHibernateTemplate().delete(post);
		} catch (Exception e) {
			System.out.println("PostImpl -> delete exception:");
		}
	}

	@Override
	public Post findByID(int id) {
		try {
			Post post = new Post();
			post = (Post) getHibernateTemplate().get("com.tk.dao.hbm.Post", id);
			return post;
		} catch (Exception e) {
			System.out.println("PostImpl -> findByID exception:");
			return null;
		}
	}

	@Override
	public List<Post> findAll() {
		try {
			List<Post> list = getHibernateTemplate().find("from com.tk.dao.hbm.Post");
			return list;
		} catch (Exception e) {
			System.out.println("PostImpl -> findAll exception:");
			return null;
		}
	}

}
