package com.market.services;

import com.market.models.Admin;

import java.util.List;

public interface AdminService {
    public Admin getFullUser(String username);
    public Admin saveUser(Admin user);
    public Admin loadUser(Admin user);
    public List<Admin> getAllAdmin();
}
