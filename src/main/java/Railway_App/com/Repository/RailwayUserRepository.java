package Railway_App.com.Repository;

import Railway_App.com.Model.RailwayUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RailwayUserRepository extends JpaRepository<RailwayUsers, Long> {

    @Query("SELECT DISTINCT ru FROM RailwayUsers ru WHERE ru.email = :email")
    List <RailwayUsers> findUsersByEmail(String email);

    List<RailwayUsers> findByEmail(String email);

//    RailwayUsers findByEmailId(@Param("email") String email);

}
