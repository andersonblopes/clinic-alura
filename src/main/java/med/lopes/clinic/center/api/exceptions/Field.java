package med.lopes.clinic.center.api.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

/**
 * The type Field.
 */
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Field {

    private final String name;
    private final String message;
}
