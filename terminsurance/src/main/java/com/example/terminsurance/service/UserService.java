package com.example.terminsurance.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.terminsurance.repo.*;
import com.example.terminsurance.data.AdminBean;
import com.example.terminsurance.data.UserBean;

@Service
public class UserService {

	@Autowired
	private UserRepo userrepo;
	
	
		public UserBean addUser(UserBean userbean) {

			return  userrepo.save(userbean);
		}
		@Autowired
		private AdminRepo adminrepo;
		public AdminBean addCustomer(AdminBean adminbean) {

			return  adminrepo.save(adminbean);
		}
		public List<AdminBean> viewUserById(String userId) {

			return (List<AdminBean>) adminrepo.findByUserId(userId);

		}
}
