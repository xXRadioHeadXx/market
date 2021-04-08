package com.govnomarket.market.service;

import com.govnomarket.market.dto.AddressDTO;

import java.util.List;

public interface IAddressService {
    public AddressDTO save(AddressDTO addressDto);

    public void deleteById(Long addressId);

    public List<AddressDTO> findAll();
    public AddressDTO getOne(Long addressId);
    public List<AddressDTO> findAllByPersonId(Long personId);
    public List<AddressDTO> findAllByAddress(String address);
}
