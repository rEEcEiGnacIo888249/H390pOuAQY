// 代码生成时间: 2025-09-21 22:26:28
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Random;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@SpringBootApplication
@RestController
public class RandomNumberGeneratorApplication {

    private static final Random random = new Random();

    public static void main(String[] args) {
        SpringApplication.run(RandomNumberGeneratorApplication.class, args);
    }

    @GetMapping("/generate")
    public ResponseEntity<Integer> generateRandomNumber(@RequestParam(value = "min", defaultValue = "1") int min,
                                                         @RequestParam(value = "max", defaultValue = "100") int max) {
        if(max < min) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(random.nextInt(max - min + 1) + min);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}