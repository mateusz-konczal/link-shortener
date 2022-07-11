package pl.sii.linkshortener.link.api;

import java.time.LocalDate;

public interface LinkService {
    LinkDto createLink(LinkDto linkDto);

    String getLink(String id);

    LinkDto getLinkDto(String id);

    void removeExpiredLinks(LocalDate date);
}
