package Railway_App.com.Repository;

import Railway_App.com.Model.BookingRide;
import Railway_App.com.Model.RailwayUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRideRepository extends JpaRepository<BookingRide, Long> {

}
