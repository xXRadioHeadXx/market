package com.govnomarket.market.service;

import com.govnomarket.market.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO save(ProductDTO productDto);

    public void deleteById(Long productId);

    public List<ProductDTO> findAll();
    public ProductDTO getOne(Long productId);

    public List<ProductDTO> findAllByName(String name);

    public List<ProductDTO> findAllByDescription(String description);

    public List<ProductDTO> findAllByCategory(String category);

    public List<ProductDTO> findAllByPriceFromTo(Long to, Long from);
}
