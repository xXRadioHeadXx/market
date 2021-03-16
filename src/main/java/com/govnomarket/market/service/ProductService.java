package com.govnomarket.market.service;

import com.govnomarket.market.dto.ProductDTO;
import com.govnomarket.market.dto.ProductDTO;
import com.govnomarket.market.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repository;
    @Override
    public ProductDTO save(ProductDTO productDto) {
        return ProductDTO.productToProductDto(repository.save(ProductDTO.productDtoToProduct(productDto)));
    }

    @Override
    public void deleteById(long productId) {
        repository.deleteById(productId);
    }

    @Override
    public List<ProductDTO> findAll() {
        return ProductDTO.productListToProductDtoList(repository.findAll());
    }

    @Override
    public ProductDTO getOne(long productId) {
        return ProductDTO.productToProductDto(repository.getOne(productId));
    }

    @Override
    public List<ProductDTO> findAllByName(String name) {
        return ProductDTO.productListToProductDtoList(repository.findAllByName(name));
    }

    @Override
    public List<ProductDTO> findAllByDescription(String description) {
        return ProductDTO.productListToProductDtoList(repository.findAllByDescription(description));
    }

    @Override
    public List<ProductDTO> findAllByCategory(String category) {
        return ProductDTO.productListToProductDtoList(repository.findAllByCategory(category));
    }

    @Override
    public List<ProductDTO> findAllByPriceFromTo(Long to, Long from) {
        return ProductDTO.productListToProductDtoList(repository.findAllByPriceFromTo(to, from));
    }
}
