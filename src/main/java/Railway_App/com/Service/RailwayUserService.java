package Railway_App.com.Service;

import Railway_App.com.Model.RailwayUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RailwayUserService {

//    public ResponseEntity<String> saveUsers(RailwayUsers railwayUsers);

    RailwayUsers saveUsers(RailwayUsers railwayUsers);

    List <RailwayUsers> findUsersByEmail(String email);

}
