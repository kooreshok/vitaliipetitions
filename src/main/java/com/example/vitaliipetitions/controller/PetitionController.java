package com.example.vitaliipetitions.controller;

import com.example.vitaliipetitions.model.Petition;
import com.example.vitaliipetitions.model.Signature;
import com.example.vitaliipetitions.service.PetitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetitionController {

    private final PetitionService petitionService;

    // Connects the Controller to the Service (Dependency Injection)
    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    // Page to view all petitions
    @GetMapping("/")
    public String viewAllPetitions(Model model) {
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "index"; // Looks for index.html in templates
    }

    // 1. Page to Create a Petition
    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("petition", new Petition());
        return "create";
    }

    @PostMapping("/save")
    public String savePetition(@ModelAttribute Petition petition) {
        // Simple logic to give it an ID
        petition.setId(String.valueOf(petitionService.getAllPetitions().size() + 1));
        petitionService.savePetition(petition);
        return "redirect:/";
    }

    // 2. Search Page & Results
    @GetMapping("/search")
    public String search(@RequestParam(value = "query", required = false) String query, Model model) {
        if (query != null) {
            model.addAttribute("results", petitionService.searchPetitions(query));
        }
        return "search";
    }

    // 3. View and Sign Page (Fixes your 404 error!)
    @GetMapping("/view/{id}")
    public String viewPetition(@PathVariable String id, Model model) {
        model.addAttribute("petition", petitionService.getPetitionById(id));
        model.addAttribute("newSignature", new Signature());
        return "view";
    }

    @PostMapping("/sign/{id}")
    public String signPetition(@PathVariable String id, @ModelAttribute Signature signature) {
        Petition p = petitionService.getPetitionById(id);
        if (p != null) {
            p.getSignatures().add(signature);
        }
        return "redirect:/view/" + id;
    }
}