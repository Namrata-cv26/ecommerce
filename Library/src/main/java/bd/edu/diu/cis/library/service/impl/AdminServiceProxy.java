package bd.edu.diu.cis.library.service.impl;

import bd.edu.diu.cis.library.dto.AdminDto;
import bd.edu.diu.cis.library.model.Admin;
import bd.edu.diu.cis.library.repository.RoleRepository;
import bd.edu.diu.cis.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class AdminServiceProxy implements AdminService {
    @Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private RoleRepository roleRepository;
    private Admin admin;

    @Override
    public Admin findByUsername(String username) {
        if(adminService==null){
            adminService=new AdminServiceImpl();}
        return adminService.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        // Implement access control logic here, if needed
        if(admin==null){
            adminService=new AdminServiceImpl();
            return adminService.save(adminDto);
        }else{
            return adminService.save(adminDto);
        }
    }
}
