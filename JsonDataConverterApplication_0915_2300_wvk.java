// 代码生成时间: 2025-09-15 23:00:11
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class JsonDataConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonDataConverterApplication.class, args);
    }

    // REST API to convert JSON data
    @PostMapping("/convert")
    public ResponseEntity<Map<String, Object>> convertJson(@RequestBody Map<String, Object> jsonData) {
        // Here you can implement your JSON conversion logic
        // This is a simple pass-through for demonstration purposes
        Map<String, Object> convertedData = new HashMap<>(jsonData);
        return ResponseEntity.ok(convertedData);
    }

    // Exception handling for the REST API
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("error", ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
