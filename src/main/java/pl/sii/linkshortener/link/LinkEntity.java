package pl.sii.linkshortener.link;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sii.linkshortener.link.api.LinkDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
class LinkEntity {

    @Id
    private String id;
    private String email;
    private String targetUrl;
    private LocalDate expirationDate;
    private int visits;

    public static LinkEntity fromDto(LinkDto linkDto) {
        return new LinkEntity(linkDto.id(), linkDto.email(), linkDto.targetUrl(),
                linkDto.expirationDate(), linkDto.visits());
    }

     LinkDto toDto() {
        return LinkDto
                .builder()
                .id(id)
                .email(email)
                .targetUrl(targetUrl)
                .expirationDate(expirationDate)
                .visits(visits)
                .build();
    }
}
