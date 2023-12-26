package com.example.demoassignment.Responsitory;

import com.example.demoassignment.Entity.Category;
import com.example.demoassignment.Entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductResponsitory extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT c FROM ProductEntity c WHERE c.name LIKE %?1%")
    List<ProductEntity> searchProduct(String keyword);
}
