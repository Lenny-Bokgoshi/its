package za.co._four.assignment.lennybokgoshi.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co._four.assignment.lennybokgoshi.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
}
