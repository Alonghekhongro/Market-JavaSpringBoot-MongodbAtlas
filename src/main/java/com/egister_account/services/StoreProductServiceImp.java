package com.egister_account.services;

import com.egister_account.models.Product;
import com.egister_account.models.Store;
import com.egister_account.models.StoreProduct;
import com.egister_account.repositories.ProductRepository;
import com.egister_account.repositories.StoreProductRepository;
import com.egister_account.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreProductServiceImp implements StoreProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    StoreProductRepository storeProductRepository;
    @Override
    public List<StoreProduct> getStoreProduct(String product_name){
        List<Product> list_product =  productRepository.search(product_name);
        List<Store> list_store = storeRepository.findAll();
        List<StoreProduct> list_store_product = new ArrayList<StoreProduct>();
        for(Store store : list_store){
            List<Product> temptPList = new ArrayList<Product>();
            for(Product product : list_product){
                if(product.getStore_id().equals(store.getId())){
                    temptPList.add(product);
                }   
            }
            StoreProduct storeProduct = new StoreProduct(store.getStore_name(),store.getAddress(), temptPList);
            list_store_product.add(storeProduct);
        }
        return list_store_product;
    }
}
