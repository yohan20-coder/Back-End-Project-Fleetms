package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.models.Location;
import com.kindosongenius.fleetmsv2.parameters.services.CountryService;
import com.kindosongenius.fleetmsv2.parameters.services.LocationService;
import com.kindosongenius.fleetmsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class
LocationController {

    @Autowired LocationService locationService;
    @Autowired StateService stateService;
    @Autowired CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("location", locationService.getAll());
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return model;
    }

    @GetMapping("/location")
    public String getAll(Model model){
        addModelAttribute(model);
        return "parameters/locationList";
    }

    @GetMapping("/locationadd")
    public String locationAdd(Model model){
        addModelAttribute(model);
        return "parameters/locationAdd";
    }

    @PostMapping("/location")
    public String save(Location location){
        locationService.save(location);
        return "redirect:/location";
    }

    @RequestMapping(value = "/location/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        locationService.delete(id);
        return "redirect:/location";
    }

    @GetMapping("/locationdetails/{id}")
    public String details(@PathVariable Integer id, Model model){
        Location location = locationService.getById(id);
        model.addAttribute("location", location);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "parameters/locationDetails";
    }

    @GetMapping("/locationedit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Location location = locationService.getById(id);
        model.addAttribute("location", location);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return "parameters/locationEdit";
    }

    @RequestMapping(value = "/location/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/location";
    }

}
