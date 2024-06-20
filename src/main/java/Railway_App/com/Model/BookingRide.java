package Railway_App.com.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Table(name = "bookRide")
@Getter
@Setter
@Entity
public class BookingRide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    private Integer numberOfSeats;
    private LocalDate bookingDate;
    private String currentDestination;
    private String desiredDestination;
}
