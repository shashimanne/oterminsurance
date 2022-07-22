package com.example.terminsurance.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminsurance.repo.*;
import com.example.terminsurance.data.AdminBean;

@Service

public class AdminService {
	

		@Autowired
		private AdminRepo adminrepo;
		
		//User Methods
		//View By userID
		public List<AdminBean> viewUserById(String userId) {

			return (List<AdminBean>) adminrepo.findByUserId(userId);

		}
		
		//View By name
			public List<AdminBean> viewUserByName(String name) {

				return (List<AdminBean>) adminrepo.findByName(name);

			} 
		
		//Delete by userId
			public int deleteCostumer(String userId) {
				
				adminrepo.deleteById(userId);
				return 1;
			}
			
		//Add User
			public List<AdminBean> fetchCostumerList() {
				return (List<AdminBean>) adminrepo.findAll();
			}
		
		//Modify Details
			public void modifyCostumer(AdminBean adminbean) {
				 adminrepo.save(adminbean);

			}
			
		//Add customer Details
			public AdminBean addCustomer(AdminBean adminbean) {

				return  adminrepo.save(adminbean);
			}
	}


