package com.kindosongenius.fleetmsv2.parameters.services;

import com.kindosongenius.fleetmsv2.parameters.models.Location;
import com.kindosongenius.fleetmsv2.parameters.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired LocationRepository locationRepository;

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    //menyimpan data
    public void save(Location location){
        locationRepository.save(location);
    }

    public void delete(Integer id){
        locationRepository.deleteById(id);
    }

    public Location getById(Integer id){
        return locationRepository.findById(id).orElse(null);
    }

}
