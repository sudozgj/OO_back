package org.dao.imp;

import java.util.List;

import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.User;
import org.util.HibernateSessionFactory;

public class UserDaoImp implements UserDao{

	@Override
	public User login(String username, String password) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from User where username=? and password=?");
			query.setParameter(0, username);
			query.setParameter(1, password);
			
			query.setMaxResults(1);
			User u = (User) query.uniqueResult();
			HibernateSessionFactory.closeSession();
			if(u!=null)
				return u;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addUser(User u) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			User user = new User();
			user.setName(u.getName());
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setCreatetime(u.getCreatetime());
			
			session.save(user);
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkUsername(String username) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from User where username=?");
			query.setParameter(0, username);
			query.setMaxResults(1);
			User user = (User) query.uniqueResult();
			HibernateSessionFactory.closeSession();
			if(user!=null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List getUserList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from User");
			List list = query.list();
			HibernateSessionFactory.closeSession();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean deleteUser(int id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			User user = (User) session.load(User.class, id);
			session.delete(user);
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
