// 代码生成时间: 2025-09-16 03:58:40
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootApplicationWithDbPool {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationWithDbPool.class, args);
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/your_database");
        dataSource.setUsername("your_username");
        dataSource.setPassword("your_password");
        dataSource.setMaximumPoolSize(10); // 设置连接池最大连接数
        dataSource.setMinimumIdle(2); // 设置连接池最小空闲连接数
        dataSource.setIdleTimeout(30000); // 设置空闲超时时间
        dataSource.setPoolName("SpringBootJPAHikariCP");
        dataSource.setRegisterMbeans(true);
        return dataSource;
    }

    @RestController
    @RequestMapping("/api")
    public class ApiController {

        @Autowired
        private YourService yourService;

        @GetMapping("/hello")
        public ResponseEntity<String> helloWorld() {
            try {
                String response = yourService.getHelloWorld();
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
            }
        }
    }

    @Service
    public class YourService {

        @Autowired
        private YourRepository yourRepository;

        public String getHelloWorld() {
            return "Hello, World from DB connection pool!";
        }
    }

    @Repository
    public interface YourRepository extends JpaRepository<YourEntity, Long> {
        // Define your custom repository methods if needed
    }

    @Entity
    public class YourEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        // Define other fields and methods
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
