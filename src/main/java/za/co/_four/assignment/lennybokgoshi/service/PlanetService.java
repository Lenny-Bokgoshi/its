package za.co._four.assignment.lennybokgoshi.service;

import org.springframework.stereotype.Service;
import za.co._four.assignment.lennybokgoshi.respository.PlanetRepository;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
}
