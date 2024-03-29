package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util. Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    public Product create(Product product) {
        productData.add(product);
        product.setProductId(String.valueOf(productData.size()));
        return product;
    }
    public Iterator<Product> findAll() {
        return productData.iterator();
    }
    public Product edit(Product product){
        for (Product currentProduct: productData) {
            if (currentProduct.getProductId().equals(product.getProductId())) {
                currentProduct.setProductQuantity(product.getProductQuantity());
                currentProduct.setProductName(product.getProductName());
                return currentProduct;
            }
        }
        return null;
    }
    public void delete(int index){
        productData.remove(index);
    }
}
