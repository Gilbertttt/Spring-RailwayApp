package Railway_App.com.Service;

import Railway_App.com.Model.RailwayUsers;
import Railway_App.com.Repository.BookingRideRepository;
import Railway_App.com.Repository.RailwayUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//import static jdk.internal.org.jline.utils.Log.info;

//import static sun.net.NetProperties.get;

@Slf4j
@Service
public class RailwayUserServiceImpl implements RailwayUserService{



    @Autowired
    private RailwayUserRepository railwayUserRepository;

    @Autowired
    private BookingRideRepository bookingRideRepository;

    @Override
    public RailwayUsers saveUsers(RailwayUsers railwayUsers) {
        return railwayUserRepository.save(railwayUsers);
    }

    @Override
    public List<RailwayUsers> findUsersByEmail(String email) {
        return railwayUserRepository.findUsersByEmail(email);
    }

}
