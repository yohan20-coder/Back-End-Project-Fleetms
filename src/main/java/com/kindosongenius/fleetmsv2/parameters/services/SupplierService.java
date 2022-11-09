package com.kindosongenius.fleetmsv2.parameters.services;

import com.kindosongenius.fleetmsv2.parameters.models.Supplier;
import com.kindosongenius.fleetmsv2.parameters.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> getAll(){
        return supplierRepository.findAll();
    }

}
