package za.co._four.assignment.lennybokgoshi.service;

import org.springframework.stereotype.Service;
import za.co._four.assignment.lennybokgoshi.respository.TrafficRepository;

@Service
public class TrafficService {

    private final TrafficRepository trafficRepository;

    public TrafficService(TrafficRepository trafficRepository) {
        this.trafficRepository = trafficRepository;
    }
}
