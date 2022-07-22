package com.example.terminsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminsurance.exception.*;
import com.example.terminsurance.data.AdminBean;
import com.example.terminsurance.data.UserBean;
import com.example.terminsurance.service.UserService;


  
@RestController
public class UserController {
	
		@Autowired
		UserService user;

			//Add User Details  	  
	   		@PostMapping(value= "/user/adduser")
	   	    public String addUser(@RequestBody UserBean userbean)
	   	  {
	   			user.addUser(userbean);
   				int e=userbean.getSalary()*10;

	   			if(userbean.getTobacco().equals("yes")||userbean.getTobacco().equals("YES")||userbean.getTobacco().equals("Yes")) {
	   				int a =(70-userbean.getAge())*200;	
	   				int b =(60-userbean.getAge())*197;
	   				int c =(50-userbean.getAge())*220;
	   				int d =(40-userbean.getAge())*309;
	   				
	   				return "Total Coverage Amount ="+"  "+e 
	   						+"		Premium upto 70 years =	"+a+"/month"
	   						+"				upto 60 years = "+b+"/month"
	   						+"				upto 50 years = "+c+"/month"
	   						+"					upto 40 years = "+d+"/month";
	   			}
	   			else if(userbean.getTobacco().equals("no")||userbean.getTobacco().equals("NO")||userbean.getTobacco().equals("No")) {
	   			int f =(70-userbean.getAge())*170;		
   				int g =(60-userbean.getAge())*167;
   				int h =(50-userbean.getAge())*186;
   				int i =(40-userbean.getAge())*262;
   				
   				return "Total Coverage Amount ="+"  "+e 
   						+"		Premium upto 70 years =	"+f+"/month"
   						+"				upto 60 years = "+g+"/month"
   						+"				upto 50 years = "+h+"/month"
   						+"					upto 40 years = "+i+"/month";
	   			}
	   			else {
	   				return"Enter valid response for tobacco consumption";
	   			}
	   	   }
	   		
	   		//add customer details
	   		
	   		@PostMapping(value= "/user/addcustomer")
	   	    public String addCustomer(@RequestBody AdminBean adminbean)
	   	  {
	   			
	   			user.addCustomer(adminbean);
	   			return "Created successfully";
	   	   }
	   		
	   		
	   		//view customer by userId
	   		
	   		@GetMapping(value= "/user/userid/{userId}")

			public List<AdminBean> viewUserByID(@PathVariable("userId")String userId)
			{ 
	   			if(user.viewUserById(userId).isEmpty())   throw new UserIdNotFoundException();

				System.out.println("Fetched Successfully");
				return user.viewUserById(userId);
			}

}
