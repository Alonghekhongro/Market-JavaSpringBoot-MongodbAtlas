package com.market.services;

import com.market.models.Register;
import com.market.models.Store;
import com.market.models.Store_sta;
import com.market.repositories.RegisterRepository;
import com.market.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public Store loadUser(Store store){
        Store st = storeRepository.findByUser(store.getUsername(), store.getPassword());
        if(st != null)
            return store;
        return null;
    }
    @Override
    public Store getFullUser(String username){
        return storeRepository.findByUserName(username);
    }
    @Override
    public List<Store> getAllStore() {
        return storeRepository.getAllStore();
    }
    @Override
    public Optional<Store> getStore(String id){
        if(storeRepository.existsById(id)){
            return storeRepository.findById(id);
        }
        return null;
    }
    @Override
    public List<Store_sta> getAllStoreByRegion(){
        List<Store_sta> list_store_sta = new ArrayList<Store_sta>();
        List<String> regions = new ArrayList<String>();
        regions.add("Vùng đỏ");
        regions.add("Vùng xanh");
        regions.add("Vùng cam");
        regions.add("Vùng vàng");
        for (String region : regions){
            Integer count =  storeRepository.getAllByRegion(region).size();
            Store_sta store_sta = new Store_sta(count, region);
            list_store_sta.add(store_sta);
        }
        return list_store_sta;
    }
}
