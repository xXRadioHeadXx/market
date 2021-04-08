package com.govnomarket.market.controller;

import com.govnomarket.market.dto.ProductDTO;
import com.govnomarket.market.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private ProductService service;

    @PostMapping("/add")
    public ProductDTO add(ProductDTO product) {
        return service.save(product);
    }

    @DeleteMapping("/delete/{productId}")
    public void delete(Long productId) {
        service.deleteById(productId);
    }

    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/one/{productId}")
    public ProductDTO getOne(Long productId) {
        return service.getOne(productId);
    }

    @GetMapping("/byName/{name}")
    public List<ProductDTO> getByName(String name) {
        return service.findAllByName(name);
    }

    @GetMapping("/byDescription/{description}")
    public List<ProductDTO> getByDescription(String description) {
        return service.findAllByDescription(description);
    }

    @GetMapping("/byCategory/{category}")
    public List<ProductDTO> getByCategory(String category) {
        return service.findAllByCategory(category);
    }

    @GetMapping("/byPrice/{from, to}")
    public List<ProductDTO> getByPrice(Long from, Long to) {
        return service.findAllByPriceFromTo(from, to);
    }

    @PutMapping("/edit/{product}")
    public ProductDTO edit(ProductDTO product) {
        return service.save(product);
    }
}
