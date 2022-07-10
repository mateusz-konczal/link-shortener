package pl.sii.linkshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import pl.sii.linkshortener.exception.LinkAlreadyExistException;

@ControllerAdvice
class LinkManagerControllerAdvisor {

    @ExceptionHandler(LinkAlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ExceptionResponse handleBusinessException(LinkAlreadyExistException e, WebRequest webRequest) {
        return new ExceptionResponse(e.getMessage());
    }
}
