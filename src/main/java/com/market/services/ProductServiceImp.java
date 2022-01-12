package com.market.services;

import com.market.models.Product;
import com.market.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public boolean deleteById(String id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product pro = product.get();
            pro.setActivity(false);
            productRepository.save(pro);
            return true;
        }
        return false;
    }
    @Override
    public Product updateProduct(Product product){
        Optional<Product> productt = productRepository.findById(product.getId());
        if(productt.isPresent()){
            Product pro = productt.get();
            if(pro.getActivity().equals(false)){
                return null;
            }
            pro.setName(product.getName());
            pro.setPrice(product.getPrice());
            pro.setOrigin(product.getOrigin());
            pro.setUnit(product.getUnit());
            pro.setUrl_image(product.getUrl_image());
            return productRepository.save(pro);
        }
        return null;
    }
    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }
}