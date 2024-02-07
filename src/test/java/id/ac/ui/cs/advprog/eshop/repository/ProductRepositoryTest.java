package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito. junit. jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind () {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
    @Test
    void testFindAllIfEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse (productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThan0neProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-aObf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep.");
        product2.setProductQuantity(50);
        productRepository.create(product2);
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }
    @Test
    public void testEditProduct() {
        Product product = new Product();
        product.setProductName("Edit Test");
        product.setProductQuantity(5);
        productRepository.create(product);
        // Edit Product
        Product updatedProduct = new Product();
        updatedProduct.setProductId(product.getProductId());
        updatedProduct.setProductName("Product New");
        updatedProduct.setProductQuantity(-5);
        Product editedProduct = productRepository.edit(updatedProduct);
        // Assert Test
        assertNotNull(editedProduct);
        assertEquals("Product New", editedProduct.getProductName());
        assertEquals(-5, editedProduct.getProductQuantity());
    }

    @Test
    public void testDeleteProduct() {
        Product product = new Product();
        product.setProductName("Delete Test");
        product.setProductQuantity(-5);

        productRepository.create(product);
        productRepository.delete(Integer.parseInt(product.getProductId()));

        // Ensure the product is no longer in the repository
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        assertEquals(allProduct.size(), 0);
    }
}