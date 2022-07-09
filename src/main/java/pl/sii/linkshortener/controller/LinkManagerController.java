package pl.sii.linkshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sii.linkshortener.dto.CreateLinkDto;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.service.LinkService;

@RestController
@RequestMapping("/links")
public class LinkManagerController {

    private final LinkService linkService;

    public LinkManagerController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link) {
        return linkService.createLink(link.toDto());
    }
}
