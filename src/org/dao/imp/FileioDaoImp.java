package org.dao.imp;

import java.util.List;

import org.dao.FileioDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Fileio;
import org.util.HibernateSessionFactory;

public class FileioDaoImp implements FileioDao{
	@Override
	public boolean addFileio(Fileio fu) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Fileio f = new Fileio();
			f.setUsername(fu.getUsername());
			f.setFilename(fu.getFilename());
			f.setUploadtime(fu.getUploadtime());
			
			session.save(f);
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List getFileioList() {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Fileio");
			List<Fileio> fList = query.list();
			HibernateSessionFactory.closeSession();
			return fList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Fileio getFileByid(int id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Query query = session.createQuery("from Fileio where id = ?");
			query.setParameter(0, id);
			
			query.setMaxResults(1);
			Fileio f = (Fileio) query.uniqueResult();
			HibernateSessionFactory.closeSession();
			if(f!=null)
				return f;
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteFile(int id) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			
			Fileio f = (Fileio) session.load(Fileio.class, id);
			session.delete(f);
			ts.commit();
			HibernateSessionFactory.closeSession();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
