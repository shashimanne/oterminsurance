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
import com.example.terminsurance.exception.ListIsEmptyException;
import com.example.terminsurance.exception.UserIdNotFoundException;
import com.example.terminsurance.exception.UserNameNotFoundException;
import com.example.terminsurance.service.*;
import com.example.terminsurance.data.*;
  
@RestController
public class AdminController {
	
		@Autowired
		AdminService admin;
		
		//view all customers
		 @GetMapping(value="/admin/costumers")
	   	    public List<AdminBean> fetchCostumerList() 
	   	    {   
			 if(admin.fetchCostumerList().isEmpty()) throw new ListIsEmptyException();
	   	  	 	return admin.fetchCostumerList();
	   	  	 	
	   	     }
		 
		 //view by userId 
		@GetMapping(value= "/admin/userid/{userId}")

		public List<AdminBean> viewUserByID(@PathVariable("userId")String userId)
		{ 
			if(admin.viewUserById(userId).isEmpty()) throw new UserIdNotFoundException();
			System.out.println("Fetched Successfully");
			return admin.viewUserById(userId);
			
		}
 
			//view by name
			@GetMapping(value= "/admin/name/{name}")

			public List<AdminBean> viewUserByName(@PathVariable("name")String name)
			{ 
				if(admin.viewUserByName(name).isEmpty()) throw new UserNameNotFoundException();
				System.out.println("Fetched Successfully");
				return admin.viewUserByName(name);

			}
			  
			//update the user details
	   		  @PutMapping(path="admin/costumer/update",consumes= {"application/json"})

	   		   public String modifyCostumer(@RequestBody AdminBean adminbean)

	   		   {
	   			  admin.modifyCostumer(adminbean);
	   		      return "Updated Sucessfully";

	   		   }
			
	   		  //delete by userId
	   		@DeleteMapping(value="admin/costumer/delete/{userId}")
			   public String deleteCostumer(@PathVariable("userId") String userId)
			   
			   {
				  System.out.println("customer deleted");
				  admin.deleteCostumer(userId);
			       return "Deleted Successfully";
			 }

}
