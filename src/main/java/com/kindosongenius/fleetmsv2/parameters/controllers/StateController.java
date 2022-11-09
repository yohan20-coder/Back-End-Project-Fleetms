package com.kindosongenius.fleetmsv2.parameters.controllers;

import com.kindosongenius.fleetmsv2.parameters.models.Country;
import com.kindosongenius.fleetmsv2.parameters.models.State;
import com.kindosongenius.fleetmsv2.parameters.services.CountryService;
import com.kindosongenius.fleetmsv2.parameters.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;

    public Model addModelAttribute(Model model){
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("countries", countryService.getAll());
        return model;
    }

    @GetMapping("/state")
    public String getAll(Model model){
//        List<State> states = stateService.getAll();
//        model.addAttribute("states", states);
        addModelAttribute(model);
        return "parameters/stateList";
    }

    @GetMapping("/stateadd")
    public String stateAdd(Model model){
        addModelAttribute(model);
        return "parameters/stateAdd";
    }

    @PostMapping("/state")
    public String save(State state){
        stateService.save(state);
        return "redirect:/state";
    }

    @GetMapping("/statedetails/{id}")
    public String countryDetails(@PathVariable Integer id, Model model){
        State state = stateService.getById(id);
        model.addAttribute("state", state);
        return "parameters/stateDetails";
    }

    @GetMapping("/stateedit/{id}")
    public String stateEdit(@PathVariable Integer id, Model model){
        addModelAttribute(model);
        model.addAttribute("state",stateService.getById(id));
        return "parameters/stateEdit";
    }

    @RequestMapping(value = "/state/update/{id}", method = {RequestMethod.GET,RequestMethod.PUT})
    public String update(State state){
       stateService.save(state);
        return "redirect:/state";
    }

    @RequestMapping(value = "/state/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
    public String delete(@PathVariable Integer id){
        stateService.delete(id);
        return "redirect:/state";
    }

}
