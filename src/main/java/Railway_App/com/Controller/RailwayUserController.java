package Railway_App.com.Controller;

import Railway_App.com.Model.BookingRide;
import Railway_App.com.Model.RailwayUsers;
import Railway_App.com.Model.Train;
import Railway_App.com.Repository.RailwayUserRepository;
import Railway_App.com.Service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/railway")
@CrossOrigin
public class RailwayUserController {

    @Autowired
    private RailwayUserService railwayUserService;

    @Autowired
    private BookingRideService bookingRideService;

    @Autowired
    private RailwayUserRepository railwayUserRepository;

    @Autowired
    private TrainService trainService;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private QrCodeGeneratorService qrCodeGeneratorService;

    @PostMapping("/addUsers")
    public RailwayUsers addUsers(@RequestBody RailwayUsers railwayUsers) {
        return railwayUserService.saveUsers(railwayUsers);
    }

    @PostMapping("/bookRide")
    public String bookingride(@RequestBody BookingRide bookingRide) {
        bookingRideService.savebookRide(bookingRide);
        return "Booked Successfully";
    }


    @GetMapping("/getUsers/{email}")
    public List<RailwayUsers> getUsersDetailsByEmail(@PathVariable String email) {
        return railwayUserService.findUsersByEmail(email);
    }


    @PostMapping("/addTrains")
    public ResponseEntity<String> addTrains(@RequestBody Train train) {
        trainService.saveTrains(train);
        return ResponseEntity.ok("Trains Added");
    }


    @GetMapping("/getTrains")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }


//    @GetMapping("/contactUsEmail")
//    public String sendEmail(@RequestParam String email) {
//      sendEmailService.sendEmail
//              (email,
//              "Thank you for Contacting us," +
//                      "We'll reach out to you soon." +
//                      "Please do not respond as this email is an automated email",
//              "SEND US A MESSAGE"
//      );
//      return "Sent Successfully";
//    }

//    @GetMapping("/paymentemail")
//    public String paymentEmail(@RequestParam String email) {
//      sendEmailService.sendEmail(
//              email,
//              "Payment Successful scan this QR codde to see your tickets" +
//                      "Have a lovely trip",
//              "Get Tickets"
//      );
//      return "Payment successful";
//    }

//    @GetMapping("/qr-code")
//    public BufferedImage generateQRCode(@RequestParam String email) throws IOException {
//        List<RailwayUsers> railwayUsers = railwayUserRepository.findByEmail(email);
//        String data = "Name: " + railwayUsers.getFullName() + "\n" +
//                "Email: " + railwayUsers.getEmail();
//        BufferedImage qrCodeImage = qrCodeGeneratorService.generateQRCode(data);
//        return qrCodeImage;
//    }

//    @PostMapping("/paymentEmail")
//    public String paymentEmail(@RequestBody String emailJson) throws IOException, MessagingException {
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode emailNode = mapper.readTree(emailJson);
//        String email = emailNode.get("email").asText();
//        System.out.println("Received email: " + email);
//        String transactionReference = UUID.randomUUID().toString();
//        RailwayUsers railwayUsers = railwayUserRepository.findByEmail(email);
//        if (railwayUsers == null) {
//            System.out.println("User not found with email:" + email);
//            return "Error: User not found";
//        } else {
//            System.out.println("User found: " + railwayUsers.getEmail());
//        }
//        String data = "Name: " + railwayUsers.getFullName() + "\n" +
//                "Email: " + railwayUsers.getEmail() + "\n" +
//                "Transaction Reference: " + transactionReference;
//        BufferedImage qrCodeImage = qrCodeGeneratorService.generateQRCode(data);
//        sendEmailService.sendEmail(
//                email,
//                "Payment Successful! Scan the QR code to see your tickets",
//                "Get Tickets",
//                qrCodeImage
//        );
//        return "Success";
//
//    }

    @PostMapping("/paymentEmail")
    public String paymentEmail(@RequestBody String emailJson) throws IOException, MessagingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode emailNode = mapper.readTree(emailJson);
        String email = emailNode.get("email").asText();
        System.out.println("Received email: " + email);
        String transactionReference = UUID.randomUUID().toString();
        List<RailwayUsers> railwayUsersList = railwayUserRepository.findByEmail(email);
        if (railwayUsersList.isEmpty()) {
            System.out.println("User not found with email:" + email);
            return "Error: User not found";
        } else {
            RailwayUsers railwayUsers = railwayUsersList.get(0); // take the first result
            System.out.println("User found: " + railwayUsers.getEmail());
            String data = "Name: " + railwayUsers.getFullName() + "\n" +
                    "Email: " + railwayUsers.getEmail() + "\n" +
                    "Transaction Reference: " + transactionReference;
            BufferedImage qrCodeImage = qrCodeGeneratorService.generateQRCode(data);
            sendEmailService.sendEmail(
                    email,
                    "Payment Successful! Scan the QR code to see your tickets",
                    "Get Tickets",
                    qrCodeImage
            );
            return "Success";
        }
    }

}
