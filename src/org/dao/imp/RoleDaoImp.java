package org.dao.imp;

import java.util.List;

import org.dao.RoleDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Role;
import org.util.HibernateSessionFactory;

public class RoleDaoImp implements RoleDao{
	@Override
	public boolean addRole(String role) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Role r = new Role();
			r.setRole(role);
			
			session.save(r);
			
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteRole(int id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Role role = (Role) session.load(Role.class, id);
			session.delete(role);
			
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkRole(String role) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Role where role=?");
			query.setParameter(0, role);
			query.setMaxResults(1);
			Role r = (Role) query.uniqueResult();
			HibernateSessionFactory.closeSession();
			if(r!=null)
				return false;
			else
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List getRoleList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Role order by id");
			List<Role> list = query.list();
			ts.commit();
			HibernateSessionFactory.closeSession();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
