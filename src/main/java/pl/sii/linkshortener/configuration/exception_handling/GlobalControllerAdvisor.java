package pl.sii.linkshortener.configuration.exception_handling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
class GlobalControllerAdvisor {

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ExceptionResponse handleError(Exception ex, WebRequest request) {
        log.error("Unexpected exception for web request: " + request, ex);
        return new ExceptionResponse(ex.getMessage());
    }
}
