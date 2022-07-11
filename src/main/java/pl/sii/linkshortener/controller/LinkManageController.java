package pl.sii.linkshortener.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.service.LinkService;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/links")
class LinkManageController {

//    private final static Logger LOGGER = Logger.getLogger(LinkManagerController.class.getName());

    private final LinkService linkService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@Valid @RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }

//    @PostMapping
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    ResponseEntity<?> createLink(@Valid @RequestBody CreateLinkDto link) { // lepsze rozwiązanie - LinkManagerControllerAdvisor
//        try {
//            return ResponseEntity.created(null).body(linkService.createLink(link.toDto()));
//        } catch (LinkAlreadyExistException e) {
//            LOGGER.info(e.getMessage());
//            return ResponseEntity.badRequest().body(new ExceptionResponse(e.getMessage()));
//        }
//    }
}
