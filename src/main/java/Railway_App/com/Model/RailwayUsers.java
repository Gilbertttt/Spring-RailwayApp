package Railway_App.com.Model;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NamedQuery(name = "RailwayUsers.findByEmailId", query = "select u from RailwayUsers u where u.email=:email")


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
public class RailwayUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;
    private String fullName;
    private String email;
    private String password;

  //booking_ride_booking_id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_book_id")
    private BookingRide bookingRide;

    public RailwayUsers() {

    }

    public boolean containsKey(String email, String password, String fullName) {
        return false;
    }

    public RailwayUsers(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
