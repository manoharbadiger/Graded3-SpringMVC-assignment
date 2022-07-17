package com.classpath.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.classpath.mvc.model.Customer;
import com.classpath.mvc.service.CustomerService;


@Controller

public class CustomerController {

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/")
	public ModelAndView listCustomers(ModelAndView model) throws IOException {
		
		List<Customer> listCustomer = customerService.getAllCustomers();
		model.addObject("customers",listCustomer);
		model.setViewName("home");
		return model;
		
	}
		
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Customer customer = new Customer();
		model.addObject(customer);
		model.setViewName("CustomerForm");
		return model;
		
	}
	
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer) {	
		  if (customer.getId()==0) { 		  
			  customerService.addCustomer(customer);			  
	        } 
		  else 
		  {	  
			  customerService.updateCustomer(customer);	           
	        }
		  
	        return new ModelAndView("redirect:/");			
	}
	
	  @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	    public ModelAndView deleteCustomer(HttpServletRequest request) {		  
		  int customerID = Integer.parseInt(request.getParameter("id"));		  
		  customerService.deleteCustomer(customerID);
	        return new ModelAndView("redirect:/");
	    }
	 
	    @RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	    public ModelAndView editContact(HttpServletRequest request) {
	    	int customerID = Integer.parseInt(request.getParameter("id"));
	    	Customer customer = customerService.getCustomer(customerID);
	        ModelAndView model = new ModelAndView("CustomerForm");
	        model.addObject("customer", customer);
	        return model;
	    }

}
