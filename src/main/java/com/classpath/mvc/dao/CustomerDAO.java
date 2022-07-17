package com.classpath.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.classpath.mvc.model.Customer;

import java.util.List;


@Repository
public class CustomerDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	

 
 
 @SuppressWarnings("unchecked")
public List<Customer> getAllCustomers(){
	 return sessionFactory.getCurrentSession().createQuery("from Customer").list();

 }
 
 public Customer getCustomer(Integer customerID) {	 
	 
	 Customer customer = (Customer) sessionFactory.getCurrentSession().get(Customer.class, customerID);

		return customer;
	 
 }
 
 public void addCustomer(Customer customer) {
	 
	 sessionFactory.getCurrentSession().saveOrUpdate(customer);
	 
 }
 
 
 public Customer updateCustomer(Customer customer){
	 
	sessionFactory.getCurrentSession().update(customer);
		
		return customer;
	 
	 
 }
 
 public void deleteCustomer(Integer customerID){
	 
	 Customer customer = (Customer) sessionFactory.getCurrentSession().load(Customer.class, customerID);
		
		if(null!= customer) {
			
		this.sessionFactory.getCurrentSession().delete(customer);
	 
 }
 }
	
	


}
