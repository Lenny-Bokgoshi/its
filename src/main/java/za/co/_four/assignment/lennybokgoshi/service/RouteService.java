package za.co._four.assignment.lennybokgoshi.service;

import org.springframework.stereotype.Service;
import za.co._four.assignment.lennybokgoshi.respository.RouteRepository;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
}
