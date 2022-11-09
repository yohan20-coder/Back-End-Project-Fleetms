package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.models.Country;
import com.kindosongenius.fleetmsv2.parameters.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public String getAll(Model model){
        List<Country> countries = countryService.getAll();
        model.addAttribute("countries", countries);
        return "parameters/countryList";
    }

    @GetMapping("/countryadd")
    public String countryAdd(){
        return "parameters/countryAdd";
    }

    @GetMapping("/countryedit/{id}")
    public String countryEdit(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryEdit";
    }

    @PostMapping("/countries")
    public String save(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        countryService.delete(id);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Country country){
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/countrydetails/{id}")
    public String countryDetails(@PathVariable Integer id, Model model){
        Country country = countryService.getById(id);
        model.addAttribute("country", country);
        return "parameters/countryDetails";
    }

    //get dropdownlist country with jquery
    @GetMapping("/parameters/country/{id}")
    @ResponseBody
    public Country getCountry(@PathVariable Integer id){
        return countryService.getById(id);
    }

}
