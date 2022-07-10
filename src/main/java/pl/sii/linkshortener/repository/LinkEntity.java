package pl.sii.linkshortener.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.sii.linkshortener.dto.LinkDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity {

    @Id
    private String id;
    private String email;
    private String targetUrl;
    private LocalDate expirationDate;
    private int visits;

    public static LinkEntity fromDto(LinkDto linkDto) {
        return new LinkEntity(linkDto.getId(), linkDto.getEmail(), linkDto.getTargetUrl(),
                linkDto.getExpirationDate(), linkDto.getVisits());
    }

    public LinkDto toDto() {
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
