package com.coderocket.sportscomp.in.exceptionHandlers;

import com.coderocket.sportscomp.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, Object> responseBody = new LinkedHashMap<>();

        responseBody.put("timestamp", DateTimeUtils.formatDateTimeAsPattern(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
        responseBody.put("status", status);
        List<String> errors = ex.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        responseBody.put("errors", errors);
        responseBody.put("path:", ((ServletWebRequest) request).getRequest().getRequestURI());

        log.debug("request failed because method argument not valid: {}, {}", request, errors);

        return new ResponseEntity<>(responseBody, headers, status);
    }
}
