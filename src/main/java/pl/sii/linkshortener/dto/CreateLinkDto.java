package pl.sii.linkshortener.dto;

import java.time.LocalDate;

public class CreateLinkDto{
        String id;
        String email;
        String targetUrl;
        LocalDate expirationDate;

        int visits;

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
