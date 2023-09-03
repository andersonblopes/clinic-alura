package med.lopes.vol.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;

/**
 * The type Error custom.
 */
@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorCustom {

    private String path;
    private String status;
    private String message;
    private String error;
    private OffsetDateTime timestamp;
}
