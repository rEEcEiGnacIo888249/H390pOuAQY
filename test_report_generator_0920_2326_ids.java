// 代码生成时间: 2025-09-20 23:26:05
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import java.io.IOException;

@SpringBootApplication
public class TestReportGenerator {

    public static void main(String[] args) {
        SpringApplication.run(TestReportGenerator.class, args);
    }

    @RestController
    class TestReportController {

        @GetMapping("/report")
        public String generateTestReport() {
            try {
                // 模拟报告生成逻辑
                String report = "Test Report Content";
                return report;
            } catch (Exception e) {
                throw new ReportGenerationException("Error generating report", e);
            }
        }
    }

    // 自定义异常类
    class ReportGenerationException extends RuntimeException {
        public ReportGenerationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // 全局异常处理器
    @RestControllerAdvice
    class GlobalExceptionHandler {

        @ExceptionHandler(ReportGenerationException.class)
        public ResponseEntity<String> handleReportGenerationException(ReportGenerationException ex) {
            return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}