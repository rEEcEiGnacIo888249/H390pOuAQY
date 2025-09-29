// 代码生成时间: 2025-09-30 03:59:21
@RestController
@RequestMapping("/api/interaction")
public class InteractionToolService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InteractionToolService.class);

    @Autowired
    private InteractionRepository interactionRepository;

    @PostMapping("/messages")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        try {
            Message savedMessage = interactionRepository.save(message);
            return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("Error saving message", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return interactionRepository.findAll();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handleExceptions(Exception ex) {
        return new ResponseEntity<>{"error": "