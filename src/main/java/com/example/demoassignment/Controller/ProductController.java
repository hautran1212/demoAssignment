package com.example.demoassignment.Controller;

import com.example.demoassignment.Entity.ProductEntity;
import com.example.demoassignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("home")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public String showHomePage(Model model){
        model.addAttribute("products", productService.getAll());
        return "HomePage";
    }
    @GetMapping("shop")
    public String shopping(Model model, @Param("keyword") String keyword, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo){
        Page<ProductEntity> list = productService.getAll(pageNo);
        if(keyword!=null){
            list = productService.searchName(keyword, pageNo);
        }
        model.addAttribute("keyword" , keyword);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("products", list);
        return "ListProduct";
    }
}
