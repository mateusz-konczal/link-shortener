package pl.sii.linkshortener.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import pl.sii.linkshortener.link.api.LinkDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

//class CreateLinkDto {
//
//    @NotBlank @Size(min = 1, max = 60)
//    @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
//    private final String id;
//
//    @NotBlank @Email
//    @Schema(description = "User email required for shortened link management (deletion, updating)", example = "test@greencashew.dev", required = true)
//    private final String email;
//
//    @NotBlank
//    @Schema(description= "Destination url we would like to ", example = "https://github.com/greencashew/warsztaty-podstawy-springa", required = true)
//    private final String targetUrl;
//
//    @Future
//    @Schema(description = "Link expiration time. If would like to have shortened link forever do not fill this field.", example = "2054-06-23")
//    private final LocalDate expirationDate;
//
//    @JsonCreator
//    public CreateLinkDto(String id, String email, String targetUrl, LocalDate expirationDate) {
//        this.id = id;
//        this.email = email;
//        this.targetUrl = targetUrl;
//        this.expirationDate = expirationDate;
//    }
//
//     LinkDto toDto() {
//        return new LinkDto(
//                id,
//                email,
//                targetUrl,
//                expirationDate,
//                0
//        );
//    }
//}

record CreateLinkDto(

        @Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
        @NotBlank @Size(min = 1, max = 60)
        String id,

        @Schema(description = "User email required for shortened link management (deletion, updating)", example = "test@greencashew.dev", required = true)
        @NotBlank @Email
        String email,

        @Schema(description = "Destination url we would like to ", example = "https://github.com/greencashew/warsztaty-podstawy-springa", required = true)
        @NotBlank
        String targetUrl,

        @Schema(description = "Link expiration time. If would like to have shortened link forever do not fill this field.", example = "2054-06-23")
        @Future
//        @PastOrPresent
        LocalDate expirationDate) {

    LinkDto toDto() {
        return new LinkDto(
                id,
                email,
                targetUrl,
                expirationDate,
                0
        );
    }
}
