package pl.sii.linkshortener.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class WebController {
    @RequestMapping("/")
    String indexHtml() {
        return "index.html";
    }
}
