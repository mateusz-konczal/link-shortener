package pl.sii.linkshortener.controller;

import pl.sii.linkshortener.dto.LinkDto;

import java.time.LocalDate;

class CreateLinkDto {
    private final String id;
    private final String email;
    private final String targetUrl;
    private final LocalDate expirationDate;

    int visits;

    public CreateLinkDto(String id, String email, String targetUrl, LocalDate expirationDate, int visits) {
        this.id = id;
        this.email = email;
        this.targetUrl = targetUrl;
        this.expirationDate = expirationDate;
        this.visits = visits;
    }

    public LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}
