package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.models.Contact;
import com.kindosongenius.fleetmsv2.parameters.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired private ContactService contactService;

    @GetMapping("/contact")
    public String getAll(Model model){
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts",contacts);
        return "parameters/contactList";
    }

    @GetMapping("/contactadd")
    public String contactAdd(){
        return "parameters/contactAdd";
    }

    @PostMapping("/contact")
    public String save(Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @GetMapping("/contactdetails/{id}")
    public String contactdetails(@PathVariable Integer id, Model model){
        Contact contact = contactService.getById(id);
        model.addAttribute("contact",contact);
        return "parameters/contactDetails";
    }

    @GetMapping("/contactedit/{id}")
    public String contactedit(@PathVariable Integer id, Model model){
        Contact contact = contactService.getById(id);
        model.addAttribute("contact",contact);
        return "parameters/contactEdit";
    }

    @RequestMapping(value = "/contact/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contact";
    }

    @RequestMapping(value = "/contact/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        contactService.delete(id);
        return "redirect:/contact";
    }

}
