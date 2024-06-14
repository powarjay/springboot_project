package com.tka.OrganizationSystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try {
		session=factory.openSession();
		
		tx=session.beginTransaction();
		
		session.persist(c);
		tx.commit();
		msg="Country is Added...";
		}catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
		e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	
		return msg;
		
	}

	public String updateCountry(int id, Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try {
			
		session=factory.openSession();
		tx=session.beginTransaction();
		
		Country country=session.get(Country.class,id);
		
		country.setCname(c.getCname());

		session.merge(country);
		tx.commit();
		
		msg="Country is Updated...";
		
		} catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg ;	
	}

	public String deleteCountry(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session=factory.openSession();
			tx=session.beginTransaction();
			
		Country country=session.get(Country.class, id);
			
		session.remove(country);
		tx.commit();
		msg="Country is Deleted....";
			
		} catch (Exception e) {

			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session=null;
		Transaction tx=null;
		//String msg=null;
		String hqlQuery="from Country";
		List<Country> list=null;
		
		try {
			
			session =factory.openSession();
			tx=session.beginTransaction();
			
			Query<Country> query= session.createQuery(hqlQuery,Country.class);
			
			list=query.list();
			
			tx.commit();
			
			
			
		} catch (Exception e) {
		
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return list;
		
		
		
	}

	public Country getParticularCountry(int id) {

		Session session=null;
		Transaction tx=null;
		Country c=null;
		
		try {
			session=factory.openSession();
			tx=session.beginTransaction();
			
			c=session.get(Country.class, id);
			
			tx.commit();
			
		} catch (Exception e) {

			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
	return c;	
	}

	public String addEmployee(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		
		try {
		
			session=factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(emp);

			tx.commit();
			
			msg="Record Added Successfully...";
			
		} catch (Exception e) {
			
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return msg;
	}
	
	
	
}
