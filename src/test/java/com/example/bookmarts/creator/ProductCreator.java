package  com.example.bookmarts.creator;

import  com.example.bookmarts.entity.Product;
import com.example.bookmarts.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@DataJpaTest
public class ProductCreator {
    @Autowired
    static ProductRepository productRepository;

    public static final String NAME = "Test";
    public static final String DESCRIPTION = "testDescriptionTestDescription";
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static final String IMAGE_URL = "https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4";

    public static Product createTestProduct(){
        Product testProduct = new Product();

        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);
        testProduct.setImageUrl(IMAGE_URL);

        testProduct.setName("product");
        testProduct.setDescription("book description");
        testProduct.setPrice( BigDecimal.valueOf(1000));
        testProduct.setImageUrl("https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4");


        return testProduct;
    }
    @Test
    public  void createProduct(){
        Product testProduct = new Product();
//
        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);
        testProduct.setImageUrl(IMAGE_URL);

//        testProduct.setName("product");
//        testProduct.setDescription("book description");
//        testProduct.setPrice( BigDecimal.valueOf(1000));
//        testProduct.setImageUrl("https://avatars1.githubusercontent.com/u/30699233?s=400&u=cf0bc2b388b5c72364aaaedf26a8aab63f97ffcc&v=4");

        productRepository.save(testProduct);
        Assertions.assertThat(testProduct.getId()).isGreaterThan(0);

    }

    public static Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }
}
