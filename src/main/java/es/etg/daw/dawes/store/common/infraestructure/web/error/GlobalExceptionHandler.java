package es.etg.daw.dawes.store.common.infraestructure.web.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, List<String>> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.computeIfAbsent(error.getField(), k -> new ArrayList<>())
                      .add(error.getDefaultMessage())
        );

        ProblemDetail pd = buildProblem(ApiError.VALIDATION);
        pd.setProperty("errors", errors);
        return pd;
    }

    @ExceptionHandler(NullPointerException.class)
    public ProblemDetail nullPointerHandler(NullPointerException nfe) {
        return buildProblem(ApiError.INTERNAL);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGenericException(Exception ex) {
        return buildProblem(ApiError.GENERIC);
    }

    private ProblemDetail buildProblem(ApiError error) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(
                error.getStatus(), getMessage(error.getDetailKey()));
        pd.setTitle(getMessage(error.getTitleKey()));
        pd.setProperty("timestamp", LocalDateTime.now());
        return pd;
    }

    private String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
}
