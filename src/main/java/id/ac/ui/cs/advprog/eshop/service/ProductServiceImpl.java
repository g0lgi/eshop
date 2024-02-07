package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }
    @Override
    public List<Product> findAll(){
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }
    @Override
    public void delete(int index){
        productRepository.delete(index);
    }
    @Override
    public void deleteByProductId(int id){
        List<Product> allProducts = findAll();
        for(int i=0; i<allProducts.size(); i++) {
            int currentProductId = Integer.parseInt(allProducts.get(i).getProductId());
            if(currentProductId == id) {
                productRepository.delete(i);
            }
        }
    }
}