// 代码生成时间: 2025-09-30 19:08:38
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class InteractionToolService {

    // 启动Spring Boot应用
    public static void main(String[] args) {
        SpringApplication.run(InteractionToolService.class, args);
    }

    // REST API端点，返回师生互动欢迎信息
    @GetMapping("/interaction")
    public String getInteraction() {
        return "Welcome to the Teacher-Student Interaction Tool!";
    }

    // 异常处理
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred: " + ex.getMessage());
    }

    // 根据需要添加其他师生互动相关的API和异常处理器
}