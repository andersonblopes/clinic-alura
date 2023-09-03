package med.lopes.vol.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * The type Error custom.
 */
@Slf4j
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"path", "timestamp", "status", "message", "fields", "error"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {

    private String path;
    private OffsetDateTime timestamp;
    private String status;
    private String message;
    List<Field> fields;
    private String details;
}
