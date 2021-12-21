package com.market.services;

import com.market.models.Register;
import com.market.repositories.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RegisterServiceImp implements RegisterService{
    @Autowired
    RegisterRepository registerRepository;
    @Override
    public Register saveStoreRegister(Register register){
        for (Register re : getAllRegister()){
            if (re.getStore_name().equals(register.getStore_name())){
                return null;
            }
        }
        register.setCreate_date(new Date(System.currentTimeMillis()));
        register.setUpdate_date(new Date(System.currentTimeMillis()));
        register.setActivity(true);
        register.setUrl_image("");
        return registerRepository.save(register);
    }
    @Override
    public List<Register> getAllRegister() {
        return registerRepository.getAllRegister();
    }
}
