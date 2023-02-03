package com.org.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.org.entity.Role;
import com.org.service.RoleService;;
@RestController
public class RoleController {


@Autowired
private RoleService roleService;
    @PostMapping({"/createNewRole"})

    public  Role createNewRole(@RequestBody Role  role){
        return roleService.createNewRole(role);
        
    } 
    
}
