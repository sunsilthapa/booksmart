package  com.example.bookmarts.service;

import  com.example.bookmarts.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void edit(long id, Product newProduct);
    void delete(long id);
    Product findById(long id);
    List<Product> findAllByOrderByIdAsc();
    long count();


}
