package com.example.demoassignment.Service;

import com.example.demoassignment.Entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductEntity> getAll();
    List<ProductEntity> searchName(String keyword);
    Page<ProductEntity> getAll(Integer pageNo);
    Page<ProductEntity> searchName(String keyword, Integer pageNo);
}
