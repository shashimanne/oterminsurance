package com.example.terminsurance.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.terminsurance.data.*;

public interface AgentRepo extends JpaRepository<AdminBean,String> {
	List<AdminBean> findByUserId(String userId);

	List<AdminBean> findByName(String name);
	
}

