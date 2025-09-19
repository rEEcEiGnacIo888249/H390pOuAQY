// 代码生成时间: 2025-09-19 09:55:18
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import java.net.URL;
import java.net.MalformedURLException;

@RestController
public class UrlValidatorService {

    @GetMapping("/validate-url")
    public ResponseEntity<?> validateUrl(@RequestParam String url) {
        try {
            // 尝试创建URL对象以验证其格式
            new URL(url);
            return ResponseEntity.ok("URL is valid");
        } catch (MalformedURLException e) {
            // 如果URL格式不正确，返回错误信息
            return ResponseEntity.badRequest().body("Invalid URL format");
        }
    }
}
