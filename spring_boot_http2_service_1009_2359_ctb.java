// 代码生成时间: 2025-10-09 23:59:34
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import javax.annotation.PostConstruct;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebHandler;
import reactor.netty.http.server.HttpServer;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

@SpringBootApplication
# 增强安全性
@RestController
@RequestMapping("/api")
public class SpringBootHttp2Service {

    @PostConstruct
    private void init() {
        // 初始化HTTP/2协议处理器
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, HTTP/2!";
    }

    // 异常处理器
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHttp2Service.class, args);
    }
# NOTE: 重要实现细节

    @Bean
    public HttpHandler httpHandler() {
# 添加错误处理
        WebHandler webHandler = new WebHandler(this);
        return HttpServer.create()
                .handle(webHandler)
                .bindNow()
# 扩展功能模块
                .onFailure(throwable -> System.err.println("HTTP/2 server failed to start: " + throwable.getMessage()))
# 改进用户体验
                .onSuccess(HttpServerInfo serverInfo -> System.out.println("HTTP/2 server started on port " + serverInfo.port()))
                .destroyOnExit();
    }
}
