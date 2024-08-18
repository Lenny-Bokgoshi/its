package za.co._four.assignment.lennybokgoshi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co._four.assignment.lennybokgoshi.domain.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
