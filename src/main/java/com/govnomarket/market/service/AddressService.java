package com.govnomarket.market.service;

import com.govnomarket.market.dto.AddressDTO;
import com.govnomarket.market.repository.IAddressRepository;
import com.govnomarket.market.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AddressService implements IAddressService {

    @Autowired
    private IAddressRepository repository;

    @Override
    public AddressDTO save(AddressDTO addressDto) {
        return AddressDTO.addressToAddressDto(repository.save(AddressDTO.addressDtoToAddress(addressDto)));
    }

    @Override
    public void deleteById(long addressId) {
        repository.deleteById(addressId);
    }

    @Override
    public List<AddressDTO> findAll() {
        return AddressDTO.addressListToAddressDtoList(repository.findAll());
    }

    @Override
    public AddressDTO getOne(long addressId) {
        return AddressDTO.addressToAddressDto(repository.getOne(addressId));
    }

    @Override
    public List<AddressDTO> findAllByPersonId(long personId) {
        return AddressDTO.addressListToAddressDtoList(repository.findAllByPersonId(personId));
    }

    @Override
    public List<AddressDTO> findAllByAddress(String address) {
        return AddressDTO.addressListToAddressDtoList(repository.findAllByAddress(address));
    }
}
