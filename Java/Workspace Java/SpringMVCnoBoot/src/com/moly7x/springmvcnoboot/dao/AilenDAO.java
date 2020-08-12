//
package com.moly7x.springmvcnoboot.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moly7x.springmvcnoboot.model.Ailen;

@Component
public class AilenDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Ailen> getAilens(){
		Session session = sessionFactory.getCurrentSession();
		List<Ailen> ailens = session.createQuery("from Ailen", Ailen.class).list();
		
		return ailens;
	}
	
	@Transactional
	public void addAilens(Ailen a){
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
	}

	@Transactional
	public Ailen getAilen(int aid) {
		Session session = sessionFactory.getCurrentSession();
		Ailen a = session.get(Ailen.class, aid);
		return a;
	}
}
