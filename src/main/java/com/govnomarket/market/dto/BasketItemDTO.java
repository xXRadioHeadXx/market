package com.govnomarket.market.dto;

import com.govnomarket.market.entity.BasketItemKey;
import com.govnomarket.market.entity.BasketItem;
import com.govnomarket.market.entity.Person;
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
public class BasketItemDTO {
    private BasketItemKey id;
    private PersonDTO person;
    private ProductDTO product;
    private Long count;

    //    @Transactional
    public static BasketItemDTO basketItemToBasketItemDto(BasketItem basketItem) {
        if(null == basketItem)
            return null;

        BasketItemDTO basketItemDTO = new BasketItemDTO();

        basketItemDTO.setId(basketItem.getId());
        basketItemDTO.setPerson(PersonDTO.personToPersonDto(basketItem.getPerson()));
        basketItemDTO.setProduct(ProductDTO.productToProductDto(basketItem.getProduct()));
        basketItemDTO.setCount(basketItem.getCount());

        return basketItemDTO;
    }

    //    @Transactional
    public static List<BasketItemDTO> basketItemListToBasketItemDtoList(List<BasketItem> basketItemList){
        List<BasketItemDTO> basketItemDTOList = new ArrayList<>();

        for (BasketItem basketItem : basketItemList) {
            BasketItemDTO basketItemDTO = basketItemToBasketItemDto(basketItem);

            if(null != basketItemDTO)
                basketItemDTOList.add(basketItemDTO);
        }
        return basketItemDTOList;
    }

    public static BasketItem basketItemDtoToBasketItem(BasketItemDTO basketItemDto) {
        if(null == basketItemDto)
            return null;

        BasketItem basketItem = new BasketItem();

        basketItem.setId(basketItemDto.getId());
        basketItem.setPerson(PersonDTO.personDtoToPerson(basketItemDto.getPerson()));
        basketItem.setProduct(ProductDTO.productDtoToProduct(basketItemDto.getProduct()));
        basketItem.setCount(basketItemDto.getCount());

        return basketItem;
    }

    public static List<BasketItem> basketItemDtoListToBasketItemList(List<BasketItemDTO> basketItemDtoList){
        List<BasketItem> basketItemList = new ArrayList<>();

        for (BasketItemDTO basketItemDto : basketItemDtoList) {
            BasketItem basketItem = basketItemDtoToBasketItem(basketItemDto);

            if(null != basketItem)
                basketItemList.add(basketItem);
        }
        return basketItemList;
    }

}
