package com.classpath.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.classpath.mvc.dao.CustomerDAO;
import com.classpath.mvc.model.Customer;

import java.util.List;


@Service
@Transactional
public class CustomerService {
	
		
		@Autowired
		private CustomerDAO customerDAO;
		
		
		public void setCustomerDAO(CustomerDAO customerDAO) {
			this.customerDAO = customerDAO;
			
		}
		
		 @Transactional
		public void addCustomer(Customer customer) {
			 customerDAO.addCustomer(customer);
			
		}
		
		 @Transactional
		public List<Customer> getAllCustomers() {
			return customerDAO.getAllCustomers();		
				
		}
		
		 @Transactional
		public void deleteCustomer(Integer customerID) {
			 customerDAO.deleteCustomer(customerID); 
				
		}
		
		public Customer getCustomer(Integer customerID) {
			return customerDAO.getCustomer(customerID);	
			
		}
		
		
		public Customer updateCustomer(Customer customer) {
			return customerDAO.updateCustomer(customer);
						
		}
		

}
