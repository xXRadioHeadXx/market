package com.govnomarket.market.service;

import com.govnomarket.market.dto.AddressDTO;

import java.util.List;

public interface IAddressService {
    public AddressDTO save(AddressDTO addressDto);

    public void deleteById(long addressId);

    public List<AddressDTO> findAll();
    public AddressDTO getOne(long addressId);
    public List<AddressDTO> findAllByPersonId(long personId);
    public List<AddressDTO> findAllByAddress(String address);
}
