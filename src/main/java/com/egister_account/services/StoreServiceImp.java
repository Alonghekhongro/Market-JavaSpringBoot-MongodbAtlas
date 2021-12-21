package com.egister_account.services;

import com.egister_account.models.Store;
import com.egister_account.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImp implements StoreService {
    @Autowired
    StoreRepository storeRepository;
    @Override
    public Store saveStore(Store store){
        for (Store st : getAllStore()){
            if (st.getUsername().equals(store.getUsername())){
                return null;
            }
        }
        store.setCreate_date(new Date(System.currentTimeMillis()));
        store.setUpdate_date(new Date(System.currentTimeMillis()));
        store.setActivity(true);
        store.setContract_start("");
        store.setContract_end("");
        store.setRules("");
        return storeRepository.save(store);
    }
    @Override
    public Store reviewStore (Store store){
        for (Store st : storeRepository.getAllStore()){
            if (st.getId().equals(store.getId())){
                st.setContract_start(store.getContract_start());
                st.setContract_end(store.getContract_end());
                st.setRules(store.getRules());
                return storeRepository.save(st);
            }
        }
        return null;
    }
    @Override
    public List<Store> getAllStore() {
        return storeRepository.getAllStore();
    }
}
