package pl.sii.linkshortener.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class WebController {
    @RequestMapping("/")
    String indexHtml() {
        return "index.html";
    }
}
