package Railway_App.com.Service;

import Railway_App.com.Model.BookingRide;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingRideService {
    public BookingRide savebookRide(BookingRide bookingRide);
}
