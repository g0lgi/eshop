package id.ac.ui.cs.advprog.eshop.functional;

import id.ac.ui.cs.advprog.eshop.model.Product;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;



@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {
    /**
     * The port number assigned to the running application during test execution.
     * Set automatically during each test run by Spring Framework's test context.
     */
    @LocalServerPort
    private int serverPort;

    /**
     * The base URL for testing. Default value to {@code http://localhost}.
     */
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String productListUrl;
    private String createProductUrl;


    @BeforeEach
    void setUp() {
        productListUrl = String.format("%s:%d/product/list", testBaseUrl, serverPort);
        createProductUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void pageTitle(ChromeDriver driver) {
        driver.get(productListUrl);
        String pageTitle = driver.getTitle();

        assertEquals("ADV Shop", pageTitle);
    }

    @Test
    void productListDisplay(ChromeDriver driver) {
        driver.get(productListUrl);
        // Check for the Header page
        String pageHeader = driver.findElement(By.tagName("h2")).getText();
        assertEquals("Product' List", pageHeader);

        // Check for the table columns
        List<WebElement> columnProductListTable = driver.findElements(By.tagName("th"));
        String[] expectedColumns = {"Product Name", "Quantity"};

        assertEquals(expectedColumns.length, columnProductListTable.size());

        for(int i=0; i<expectedColumns.length; i++){
            WebElement correspondingColumn = columnProductListTable.get(i);
            String expectedColumnName = expectedColumns[i];
            assertEquals(expectedColumnName, correspondingColumn.getText());
        }
    }

    @Test
    void createProductSuccess(ChromeDriver driver) {
        // Simulate clicking create product
        driver.get(productListUrl);
        WebElement createButton = driver.findElement(By.linkText("Create Product"));
        createButton.click();
        // Creating product object
        Product product = new Product();
        product.setProductName("Product A");
        product.setProductQuantity(5);
        // Inputting product to the form
        WebElement productNameInput = driver.findElement(By.name("productName"));
        productNameInput.sendKeys(product.getProductName());
        WebElement productQuantityInput = driver.findElement(By.name("productQuantity"));
        productQuantityInput.clear();
        productQuantityInput.sendKeys(Integer.toString(product.getProductQuantity()));

        WebElement buttonCreate = driver.findElement(By.tagName("button"));
        buttonCreate.click();

        // check if back to the product list
        String currentUrl = driver.getCurrentUrl();
        assertEquals(productListUrl, currentUrl);

        // check if new product exists
        String pageSource = driver.getPageSource();
        List<WebElement> rowElement = driver.findElements(By.tagName("td"));

        Boolean newProductFound = false;
        for(WebElement element: rowElement){
            // check if this row is the data we are looking for
            if(element.getText().equals(product.getProductName())){
                newProductFound = true;
                break;
            }
        }
        assertTrue(newProductFound);
    }
}