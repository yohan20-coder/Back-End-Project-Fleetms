package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.models.Client;
import com.kindosongenius.fleetmsv2.parameters.services.ClientService;
import com.kindosongenius.fleetmsv2.parameters.services.CountryService;
import com.kindosongenius.fleetmsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired private ClientService clientService;
    @Autowired private CountryService countryService;
    @Autowired private StateService stateService;

    public Model addModelAttribute(Model model){
        model.addAttribute("client", clientService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return model;
    }

    @GetMapping("/client")
    public String getAll(Model model){
        List<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "parameters/clientList";
    }

    @GetMapping("/clientadd")
    public String clientAdd(Model model){
        addModelAttribute(model);
        return "parameters/clientAdd";
    }

    @PostMapping("/client")
    public String save(Client client){
        clientService.save(client);
        return "redirect:/client";
    }

    @GetMapping("/clientdetails/{id}")
    public String details(@PathVariable Integer id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "parameters/clientDetails";
    }

    @GetMapping("/clientedit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Client client = clientService.getById(id);
        model.addAttribute("client", client);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "parameters/clientEdit";
    }

    @RequestMapping(value = "/client/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value = "/client/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        clientService.delete(id);
        return "redirect:/client";
    }

}
