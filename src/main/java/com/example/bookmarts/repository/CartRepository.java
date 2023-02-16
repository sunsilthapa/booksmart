package com.example.bookmarts.repository;
import com.example.bookmarts.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {
//    List<Cart> findByUserId(String userId);
@Query(value = "SELECT * FROM cart where user_id=?1", nativeQuery = true)
List<Cart> findFavoriteById(Integer id);

@Query(value = "DELETE from cart where user_id=?1", nativeQuery = true)
    Integer deleteByUser(Integer id);
}
