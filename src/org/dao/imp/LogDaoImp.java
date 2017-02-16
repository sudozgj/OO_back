package org.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.dao.LogDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Log;
import org.util.HibernateSessionFactory;
import org.view.VLog;

public class LogDaoImp implements LogDao{
	@Override
	public boolean addLog(Log log) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();

			Log l = new Log();
			l.setUsername(log.getUsername());
			l.setOperation(log.getOperation());
			l.setTime(log.getTime());
			
			session.save(l);
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List getLogList02() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Log order by id");
			List<Log> list = query.list();
			HibernateSessionFactory.closeSession();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List getLogList() {
		try {
			Session session = HibernateSessionFactory.getSession();

			String sql = "select * from v_log order by id";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.addEntity(VLog.class);
			List<VLog> li = sqlQuery.list();
			
			List list = new ArrayList<>();
			for(VLog l : li){
				list.add(l.getId());
			}
			HibernateSessionFactory.closeSession();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
