package com.example.vitaliipetitions.service;

import com.example.vitaliipetitions.model.Petition;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PetitionService {

    private final Map<String, Petition> petitionVault = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        savePetition(new Petition("1", "Save the Park", "Stop the construction."));
        savePetition(new Petition("2", "Free Coffee", "Coffee for everyone."));
        savePetition(new Petition("3", "Better Wi-Fi", "Faster internet now."));
    }

    public void savePetition(Petition petition) {
        petitionVault.put(petition.getId(), petition);
    }

    public List<Petition> getAllPetitions() {
        return new ArrayList<>(petitionVault.values());
    }

    public Petition getPetitionById(String id) {
        return petitionVault.get(id);
    }

    public List<Petition> searchPetitions(String query) {
        return petitionVault.values().stream()
                .filter(p -> p.getTitle().toLowerCase().contains(query.toLowerCase()))
                .toList();
    }
}