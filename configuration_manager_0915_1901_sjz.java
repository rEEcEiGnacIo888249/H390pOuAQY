// 代码生成时间: 2025-09-15 19:01:48
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
@RequestMapping("/config")
public class ConfigurationManager {

    @Value("{some.value:default}")
    private String someValue;

    @GetMapping("/getValue")
    public ResponseEntity<String> getValue(@RequestParam(name = "key", defaultValue = "some.value") String key) {
        return ResponseEntity.ok(someValue);
    }

    // 异常处理
    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationManager.class, args);
    }
}
