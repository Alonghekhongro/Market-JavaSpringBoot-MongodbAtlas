package com.market.services;

import com.market.models.Product;
import com.market.models.Store;
import com.market.models.StoreProduct;
import com.market.repositories.ProductRepository;
import com.market.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreProductServiceImp implements StoreProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StoreRepository storeRepository;
    @Override
    public List<StoreProduct> getStoreProduct(String product_name){
        List<Product> list_product =  productRepository.search(product_name);
        List<Store> list_store = storeRepository.findAll();
        List<StoreProduct> list_store_product = new ArrayList<StoreProduct>();
        if (list_product.isEmpty()){
            return list_store_product;
        }
        for(Store store : list_store){
            List<Product> temptPList = new ArrayList<Product>();
            for(Product product : list_product){
                if(product.getStore_id().equals(store.getId())){
                    temptPList.add(product);
                }   
            }
            StoreProduct storeProduct = new StoreProduct(
                    store.getStore_name(), store.getAddress(), temptPList);
            list_store_product.add(storeProduct);
        }
        return list_store_product;
    }
}
