package com.example.demoassignment.Service.Impl;

import com.example.demoassignment.Entity.ProductEntity;
import com.example.demoassignment.Responsitory.ProductResponsitory;
import com.example.demoassignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductResponsitory productResponsitory;
    @Override
    public List<ProductEntity> getAll() {
        return productResponsitory.findAll();
    }

    @Override
    public List<ProductEntity> searchName(String keyword) {
        return productResponsitory.searchProduct(keyword);
    }

    @Override
    public Page<ProductEntity> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        return this.productResponsitory.findAll(pageable);
    }

    @Override
    public Page<ProductEntity> searchName(String keyword, Integer pageNo) {
        List list = productResponsitory.searchProduct(keyword);

        Pageable pageable = PageRequest.of(pageNo-1,2);
        Integer start = (int) pageable.getOffset();
        Integer end = (int) ((pageable.getOffset()+pageable.getPageSize()) > list.size() ? list.size() :pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);

        return new PageImpl<ProductEntity>(list, pageable,productResponsitory.searchProduct(keyword).size());
    }
}
