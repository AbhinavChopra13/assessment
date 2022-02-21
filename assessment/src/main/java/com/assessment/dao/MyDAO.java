package com.assessment.dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.assessment.entity.MyEntity;


public class MyDAO implements MyDAOInterface {

	@Override
	public int createProfileDAO(MyEntity w) {
		int i=0;
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		EntityTransaction et=ss.getTransaction();
		et.begin();
			ss.save(w);
		et.commit();
		i=1;
		return i;
	}

	@Override
	public boolean loginProfileDAO(MyEntity m) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assessment.entity.MyEntity m where m.email=:em1 and m.password=:ps");
		q.setParameter("em1", m.getEmail());
		q.setParameter("ps", m.getPassword());
		
		List<MyEntity> ll=q.getResultList();
		
		if(ll.size()>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkemailDAO(MyEntity m) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assessment.entity.MyEntity m where m.email=:em1");
		q.setParameter("em1", m.getEmail());
		
		List<MyEntity> ll=q.getResultList();
		if(ll.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public MyEntity viewprofileDAO(MyEntity m) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assessment.entity.MyEntity m where m.email=:em1");
		q.setParameter("em1", m.getEmail());
		
		MyEntity mb=(MyEntity)q.getSingleResult();
		
		return mb;
	}

	@Override
	public int deleteProfileDAO(MyEntity m) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
		
		Query q=ss.createQuery("delete from com.assessment.entity.MyEntity m where m.email=:em1");
		q.setParameter("em1", m.getEmail());
		
		int i=q.executeUpdate();
		
		et.commit();
		return i;
	}

	@Override
	public List<MyEntity> viewallprofileDAO(MyEntity m) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		
		Query q=ss.createQuery("from com.assessment.entity.MyEntity m ");
		
		
		List<MyEntity> ll=q.getResultList();
		return ll;
	}

}
