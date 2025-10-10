// 代码生成时间: 2025-10-10 21:18:48
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Random;

@SpringBootApplication
@RestController
@RequestMapping("/api/testdata")
public class TestDataGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDataGeneratorApplication.class, args);
    }

    @GetMapping("/number")
    public ResponseEntity<Integer> generateRandomNumber() {
        try {
            Random random = new Random();
            int randomNumber = random.nextInt(100);
            return ResponseEntity.ok(randomNumber);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Global exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
    }
}
