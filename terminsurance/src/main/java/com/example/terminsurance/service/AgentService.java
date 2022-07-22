package com.example.terminsurance.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminsurance.repo.*;
import com.example.terminsurance.data.AdminBean;

@Service

public class AgentService {
	

		@Autowired
		private AgentRepo agentrepo;
		
		//User Methods
		//View By userID
		public List<AdminBean> viewUserById(String userId) {

			return (List<AdminBean>) agentrepo.findByUserId(userId);

		}
		
		//View By name
			public List<AdminBean> viewUserByName(String name) {

				return (List<AdminBean>) agentrepo.findByName(name);

			} 
		
			public List<AdminBean> fetchCostumerList() {
				return (List<AdminBean>) agentrepo.findAll();
			}
		

			
	}
	


