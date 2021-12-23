package com.market.services;

import com.market.models.Admin;
import com.market.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin getFullUser(String username){
        return adminRepository.findByUserName(username);
    }
    @Override
    public Admin saveUser(Admin user){
        for (Admin admin : getAllAdmin()){
            if (admin.getUsername().equals(user.getUsername())){
                return null;
            }
        }
        user.setCreate_date(new Date(System.currentTimeMillis()));
        user.setUpdate_date(new Date(System.currentTimeMillis()));
        user.setActivity(true);
        return adminRepository.save(user);
    }
    @Override
    public Admin loadUser(Admin user) {
        Admin admin = adminRepository.findByUser(user.getUsername(), user.getPassword());
        if(admin != null)
            return user;
        return null;
    }
    @Override
    public List<Admin> getAllAdmin() {
        return adminRepository.getAllAdmin();
    }
}
