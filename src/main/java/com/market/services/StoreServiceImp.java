package com.market.services;

import com.market.models.Register;
import com.market.models.Store;
import com.market.repositories.RegisterRepository;
import com.market.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    RegisterRepository registerRepository;
    @Override
    public Store reviewStore (Store storee){
        for (Register re : registerRepository.getAllRegister()){
            if (re.getId().equals(storee.getId())){
                Store store = new Store();
                store.setStore_name(re.getStore_name());
                store.setPhone(re.getPhone());
                store.setEmail(re.getEmail());
                store.setPerson_name(re.getPerson_name());
                store.setPerson_phone(re.getPerson_phone());
                store.setRegion(re.getRegion());
                store.setUsername(storee.getUsername());
                store.setPassword(storee.getPassword());
                store.setContract_start(storee.getContract_start());
                store.setContract_end(storee.getContract_end());
                store.setRules(storee.getRules());
                store.setUrl_image(re.getUrl_image());
                store.setActivity(true);
                store.setAddress(re.getAddress());
                store.setCreate_date(new Date(System.currentTimeMillis()));
                store.setUpdate_date(new Date(System.currentTimeMillis()));
                for (Store st : storeRepository.getAllStore()){
                    if (st.getStore_name().equals(store.getStore_name())){
                        return null;
                    }
                }
                return storeRepository.save(store);
            }
        }
        return null;
    }
    @Override
    public List<Store> getAllStore() {
        return storeRepository.getAllStore();
    }
}
