package com.kindosongenius.fleetmsv2.parameters.services;
import com.kindosongenius.fleetmsv2.parameters.models.State;
import com.kindosongenius.fleetmsv2.parameters.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    //menampilkan semua data country
    public List<State> getAll(){
        return stateRepository.findAll();
    }

    //menyimpan data
    public void save(State state){
        stateRepository.save(state);
    }

    //menghapus data
    public void delete(Integer id){
        stateRepository.deleteById(id);
    }

    //tampil data berdasarkan id
    public State getById(Integer id){
        return stateRepository.findById(id).orElse(null);
    }

}
