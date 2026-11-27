package es.etg.daw.dawes.store.common.infraestructure.web.error;

import org.springframework.http.HttpStatus;

public enum ApiError {
    VALIDATION   (HttpStatus.BAD_REQUEST,             "error.validation"),
    INTERNAL     (HttpStatus.INTERNAL_SERVER_ERROR,   "error.internal"),
    GENERIC      (HttpStatus.INTERNAL_SERVER_ERROR,   "error.generic");

    private static final String TITLE_SUFFIX  = ".title";
    private static final String DETAIL_SUFFIX = ".detail";

    private final HttpStatus status;
    private final String prefix;

    ApiError(HttpStatus status, String prefix) {
        this.status = status;
        this.prefix = prefix;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getTitleKey() {
        return prefix + TITLE_SUFFIX;
    }

    public String getDetailKey() {
        return prefix + DETAIL_SUFFIX;
    }
}