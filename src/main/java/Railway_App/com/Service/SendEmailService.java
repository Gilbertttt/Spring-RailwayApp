package Railway_App.com.Service;

import com.google.zxing.WriterException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmailId;

    public void sendEmail(String to, String subject, String body, BufferedImage qrCodeImage)throws IOException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
             helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        // Add the QR code as an attachment
            if (qrCodeImage!= null) {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {;
            ImageIO.write(qrCodeImage, "png", bos);
            byte[] qrCodeBytes = bos.toByteArray();
            helper.addAttachment("qr_code.png", new ByteArrayResource(qrCodeBytes));
            javaMailSender.send(message);
        } catch (IOException e) {
            // Handle the exception
            System.err.println("Error writing image to byte array: " + e.getMessage());
        }
        }
    }
}