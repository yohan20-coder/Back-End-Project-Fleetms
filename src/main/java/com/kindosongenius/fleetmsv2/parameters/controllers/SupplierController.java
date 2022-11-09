package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.services.CountryService;
import com.kindosongenius.fleetmsv2.parameters.services.StateService;
import com.kindosongenius.fleetmsv2.parameters.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SupplierController {

    @Autowired SupplierService supplierService;
    @Autowired CountryService countryService;
    @Autowired StateService stateService;

    public Model addModelAttribute(Model model){
        model.addAttribute("supplier", supplierService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return model;
    }

    @GetMapping("/supplier")
    public String getAll(Model model){
        addModelAttribute(model);
        return "parameters/SupplierList";
    }


}
