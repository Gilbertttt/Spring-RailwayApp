package Railway_App.com.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RailwayUtils {

    private RailwayUtils() {

    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}", httpStatus);
    }
}
