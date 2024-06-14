package com.tka.OrganizationSystem.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainService {

	@Autowired
	MainDao dao;
	
	
	public String addCountry(Country c) {
	
		String msg=dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country is Not Added...";
		}
		return msg;
	}


	public String updateCountry(int id, Country c) {
		String msg=dao.updateCountry(id,c);
	if(Objects.isNull(msg)) {
		msg="Country is not updatated...";
	}
	return msg;
	}


	public String deleteCountry(int id) {
		
		String msg=dao.deleteCountry(id);
		if(Objects.isNull(msg)) {
			msg="Country is not Deleted";
		}
		return msg;
	}
	public List<Country> getAllCountry() {
		
		List<Country> list=dao.getAllCountry();
		
		if(Objects.isNull(list)) {
			list=null;
		}
	return list;
	}
	public Country getParticularCountry(int id) {
		String msg=null;
		Country c=dao.getParticularCountry(id);
		if(Objects.isNull(c)) {
			msg="Record not Found...";
			System.out.println(msg);
		}
		return c;
	}


	public String addEmployee(Employee emp) {
		String msg=dao.addEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg="Record is not be Added...";
		}
		return msg;
		
	}
	
}
