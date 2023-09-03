package med.lopes.vol.api.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handler data integrity violation exception response entity.
     *
     * @param exception the exception
     * @param request   the request
     * @return the response entity
     */
    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    protected ResponseEntity<Object> handlerDataIntegrityViolationException(RuntimeException exception, WebRequest request) {
        String bodyResponse = "Attempt to duplicate data";
        var error = buildError(request.getContextPath(), bodyResponse, exception);
        return handleExceptionInternal(exception, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    private ErrorCustom buildError(String path, String bodyResponse, Exception exception) {
        return ErrorCustom.builder()
                .path(path)
                .message(bodyResponse)
                .error(exception.getLocalizedMessage())
                .timestamp(OffsetDateTime.now())
                .build();
    }
}
