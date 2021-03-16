package com.govnomarket.market.dto;

import com.govnomarket.market.entity.Product;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Getter
@Setter
@EqualsAndHashCode
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private Long price;


    //    @Transactional
    public static ProductDTO productToProductDto(Product product) {
        if(null == product)
            return null;

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(product.getCategory());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }

    //    @Transactional
    public static List<ProductDTO> productListToProductDtoList(List<Product> productList){
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Product product : productList) {
            ProductDTO productDTO = productToProductDto(product);

            if(null != productDTO)
                productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    //    @Transactional
    public static Product productDtoToProduct(ProductDTO productDto) {
        if(null == productDto)
            return null;

        Product product = new Product();

        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());

        return product;
    }

    //    @Transactional
    public static List<Product> productDtoListToProductList(List<ProductDTO> productDtoList){
        List<Product> productList = new ArrayList<>();

        for (ProductDTO productDto : productDtoList) {
            Product product = productDtoToProduct(productDto);

            if(null != product)
                productList.add(product);
        }
        return productList;
    }

}
