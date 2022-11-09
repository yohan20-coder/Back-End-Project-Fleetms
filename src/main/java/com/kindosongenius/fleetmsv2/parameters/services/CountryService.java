package com.kindosongenius.fleetmsv2.parameters.services;

import com.kindosongenius.fleetmsv2.parameters.models.Country;
import com.kindosongenius.fleetmsv2.parameters.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //menampilkan semua data country
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    //menyimpan data
    public void save(Country country){
        countryRepository.save(country);
    }

    //menghapus data
    public void delete(Integer id){
        countryRepository.deleteById(id);
    }

    //tampil data berdasarkan id
    public Country getById(Integer id){
        return countryRepository.findById(id).orElse(null);
    }

}
