// 代码生成时间: 2025-09-19 18:56:32
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
public class WebContentGrabberApplication {

    private final RestTemplate restTemplate;

    public WebContentGrabberApplication(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/grabContent/{url}")
    public ResponseEntity<String> grabContent(@PathVariable String url) {
        try {
            return restTemplate.getForEntity(url, String.class);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred while fetching content: " + e.getMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body("An error occurred: " + e.getMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(WebContentGrabberApplication.class, args);
    }
}