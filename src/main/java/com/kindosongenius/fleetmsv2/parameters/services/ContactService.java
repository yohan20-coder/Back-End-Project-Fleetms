package com.kindosongenius.fleetmsv2.parameters.services;

import com.kindosongenius.fleetmsv2.parameters.models.Contact;
import com.kindosongenius.fleetmsv2.parameters.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired private ContactRepository contactRepository;

    //menampilkan semua data
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }

    //simpan data contact
    public void save(Contact contact){
        contactRepository.save(contact);
    }

    //hapus data
    public void delete(Integer id){
        contactRepository.deleteById(id);
    }

    //tampil data berdasarkan id
    public Contact getById(Integer id){
       return contactRepository.findById(id).orElse(null);
    }

}
