package com.example.terminsurance.repo;

//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.terminsurance.data.UserBean;

public interface UserRepo extends JpaRepository<UserBean,String> {

	
}
