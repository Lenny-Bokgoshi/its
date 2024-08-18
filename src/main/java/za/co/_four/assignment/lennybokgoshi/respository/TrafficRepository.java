package za.co._four.assignment.lennybokgoshi.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co._four.assignment.lennybokgoshi.domain.Traffic;

@Repository
public interface TrafficRepository extends CrudRepository<Traffic, Long> {
}
