package com.example.terminsurance.data;

import com.sun.istack.NotNull;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "UserData")
@Data
public class UserBean {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;

    @NotNull
    @Column(name = "name", nullable = false)
    public String name;
    
    @Column(name = "age", columnDefinition = "INTEGER")
    public int age;
    
    @Column(name = "gender", columnDefinition = "TEXT")
    public String gender ;
    
    @Column(name = "tobacco", columnDefinition = "TEXT")
    public String tobacco;
    
    @NotNull
    @Column(name = "salary", nullable = false )
    public int salary;
    
    @Column(name = "phone_no")
    public long phone_no;
  

   
}
