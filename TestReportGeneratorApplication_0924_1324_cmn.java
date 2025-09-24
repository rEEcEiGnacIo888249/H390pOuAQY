// 代码生成时间: 2025-09-24 13:24:03
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class TestReportGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestReportGeneratorApplication.class, args);
    }

    // API to generate a test report as a string
    @GetMapping("/generateReport")
    public ResponseEntity<String> generateReport() {
        String report = "Test Report Generated Successfully";
        return ResponseEntity.ok(report);
    }

    // Exception handler for handling exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
