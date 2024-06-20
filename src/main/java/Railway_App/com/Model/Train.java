package Railway_App.com.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "trains")
@Getter
@Setter
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainId;
    private String stationName;
    private LocalTime arrivaltime;
    private LocalTime departureTime;
}
