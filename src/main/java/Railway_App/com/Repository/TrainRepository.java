package Railway_App.com.Repository;

import Railway_App.com.Model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {


//    List<Train> getAllTrains(List<Train> train);
}
