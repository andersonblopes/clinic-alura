package med.lopes.vol.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Environment environment;

    private final MessageSource messageSource;

    /**
     * Instantiates a new Global exception handler.
     *
     * @param messageSource the message source
     * @param environment   the environment
     */
    public GlobalExceptionHandler(MessageSource messageSource, Environment environment) {
        this.messageSource = messageSource;
        this.environment = environment;
    }

    /**
     * Handle data integrity violation exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handleDataIntegrityViolationException(RuntimeException exception, WebRequest request) {
        String bodyResponse = "Attempt to duplicate data";
        var error = buildError(request, bodyResponse, exception);
        return handleExceptionInternal(exception, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    /**
     * Handle method argument not valid response entity.
     *
     * @param exception the exception
     * @param headers   the headers
     * @param status    the status
     * @param request   the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Field> fieldsErrors = new ArrayList<>();
        String bodyResponse = "Some fields are poorly filled. Please check then and try again";

        for (ObjectError error : exception.getBindingResult().getAllErrors()) {

            String errorFieldName = ((FieldError) error).getField();
            String errorMessage = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            Field field = Field.builder().name(errorFieldName).message(errorMessage).build();

            fieldsErrors.add(field);
        }

        var exceptionMessage = buildError(request, bodyResponse, exception);
        exceptionMessage.setFields(fieldsErrors);

        return handleExceptionInternal(exception, exceptionMessage, headers, status, request);
    }

    private ExceptionMessage buildError(WebRequest webRequest, String bodyResponse, Exception exception) {

        HttpServletRequest request = ((ServletWebRequest) webRequest).getRequest();
        String details = null;

        if (!environment.acceptsProfiles(Profiles.of("prod"))) {
            details = exception.getMessage();
        }

        return ExceptionMessage.builder()
                .path(request.getRequestURL().toString())
                .message(bodyResponse)
                .details(details)
                .timestamp(OffsetDateTime.now())
                .build();
    }
}
