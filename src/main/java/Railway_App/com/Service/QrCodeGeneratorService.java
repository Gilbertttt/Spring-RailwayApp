package Railway_App.com.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.rmi.RemoteException;

@Service
public class QrCodeGeneratorService {

    public BufferedImage generateQRCode(String data) throws IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 256, 256);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    } catch (WriterException e) {
            throw new RemoteException("Error Generating QR code", e);
        }
    }
}
