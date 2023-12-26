package com.example.demoassignment.Responsitory;

import com.example.demoassignment.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryResponsitory extends JpaRepository<Category, Long> {
}
