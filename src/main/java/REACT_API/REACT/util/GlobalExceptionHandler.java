package REACT_API.REACT.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(
            RuntimeException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "FAILED");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(
                response,
                HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingParam(
            MissingServletRequestParameterException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "FAILED");
        response.put("message",
                "Required parameter '" + ex.getParameterName() + "' is missing");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
    
    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<Map<String, Object>> handleMissingPart(
            MissingServletRequestPartException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", "FAILED");
        response.put("message",
                "SCREENSHOT '" + ex.getRequestPartName() + "' is missing");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, Object> response = new HashMap<>();

        String errorMessage = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        response.put("status", "FAILED");
        response.put("message", errorMessage);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
    
    
    
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleTransactionNotFound(
            TransactionNotFoundException ex) {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "FAILED");
        response.put("message", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    
    

    
}