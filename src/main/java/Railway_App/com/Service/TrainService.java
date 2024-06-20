package Railway_App.com.Service;

import Railway_App.com.Model.RailwayUsers;
import Railway_App.com.Model.Train;
import Railway_App.com.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public Train saveTrains(Train train) {
        return trainRepository.save(train);
    }

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

}
