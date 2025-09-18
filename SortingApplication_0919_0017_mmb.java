// 代码生成时间: 2025-09-19 00:17:52
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SortingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortingApplication.class, args);
    }
}

@RestController
class SortingController {

    @GetMapping("/sort")
    public ResponseEntity<List<Integer>> sortNumbers(@RequestParam List<Integer> numbers) {
        try {
            if (numbers == null || numbers.isEmpty()) {
                throw new IllegalArgumentException("Numbers cannot be empty or null.");
            }
            return ResponseEntity.ok(
                Arrays.stream(numbers.spliterator(), false).sorted().collect(Collectors.toList())
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
