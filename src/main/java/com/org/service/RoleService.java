package com.org.service;
import org.springframework.stereotype.Service;
import com.org.entity.Role;
import com.org.repo.RoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class RoleService {

  @Autowired
    private RoleRepo roleRepo;


    public Role createNewRole(Role role){

 return roleRepo.save(role);



    }
    
}
