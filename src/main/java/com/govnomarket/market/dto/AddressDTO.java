package com.govnomarket.market.dto;

import com.govnomarket.market.entity.Address;
import com.govnomarket.market.entity.Person;
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
public class AddressDTO {
    private Long id;
    private Long userId;
    private PersonDTO person;
    private String address;


    //    @Transactional
    public static AddressDTO addressToAddressDto(Address address) {
        if(null == address)
            return null;

        AddressDTO addressDto = new AddressDTO();

        addressDto.setId(address.getId());
        addressDto.setPerson(PersonDTO.personToPersonDto(address.getPerson()));
        addressDto.setAddress(address.getAddress());

        return addressDto;
    }

    //    @Transactional
    public static List<AddressDTO> addressListToAddressDtoList(List<Address> addressList){
        List<AddressDTO> addressDtoList = new ArrayList<>();

        for (Address address : addressList) {
            AddressDTO addressDto = addressToAddressDto(address);

            if(null != addressDto)
                addressDtoList.add(addressDto);
        }
        return addressDtoList;
    }

    public static Address addressDtoToAddress(AddressDTO addressDto) {
        if(null == addressDto)
            return null;

        Address address = new Address();

        address.setId(addressDto.getId());
        address.setPerson(PersonDTO.personDtoToPerson(addressDto.getPerson()));
        address.setAddress(addressDto.getAddress());

        return address;
    }

    public static List<Address> addressDtoListToAddressList(List<AddressDTO> addressDtoList){
        List<Address> addressList = new ArrayList<>();

        for (AddressDTO addressDto : addressDtoList) {
            Address address = addressDtoToAddress(addressDto);

            if(null != address)
                addressList.add(address);
        }
        return addressList;
    }
}
