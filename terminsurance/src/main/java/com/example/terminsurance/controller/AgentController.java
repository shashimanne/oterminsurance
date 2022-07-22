package com.example.terminsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.terminsurance.service.*;
import com.example.terminsurance.data.*;
import com.example.terminsurance.exception.ListIsEmptyException;
import com.example.terminsurance.exception.UserIdNotFoundException;
import com.example.terminsurance.exception.UserNameNotFoundException;
  
@RestController
public class AgentController {
	
		@Autowired
		AgentService agent;
		
		//view all customers
		
		 @GetMapping(value="/agent/costumers")
	   	    public List<AdminBean> fetchsCostumerList() 
	   	    {     
			 if(agent.fetchCostumerList().isEmpty()) throw new ListIsEmptyException();
	   	  	 	return agent.fetchCostumerList();
	   	     }
		 
		 //view customer by Id
		 
		@GetMapping(value= "/agent/userid/{userId}")

		public List<AdminBean> viewUserByID(@PathVariable("userId")String userId)
		{ 
			if(agent.viewUserById(userId).isEmpty()) throw new UserIdNotFoundException();
			System.out.println("Fetched Successfully");
			return agent.viewUserById(userId);
		}
 
		//view customer by name
			@GetMapping(value= "/agent/name/{name}")

			public List<AdminBean> viewUserByName(@PathVariable("name")String name)
			{ 
				if(agent.viewUserByName(name).isEmpty()) throw new UserNameNotFoundException();
				System.out.println("Fetched Successfully");
				return agent.viewUserByName(name);
 
			}

}
