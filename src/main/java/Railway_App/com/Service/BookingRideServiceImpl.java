package Railway_App.com.Service;

import Railway_App.com.Model.BookingRide;
import Railway_App.com.Repository.BookingRideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingRideServiceImpl implements BookingRideService{
    @Autowired
    public BookingRideRepository bookingRideRepository;

    @Override
    public BookingRide savebookRide(BookingRide bookingRide) {
        return bookingRideRepository.save(bookingRide);
    }
}
