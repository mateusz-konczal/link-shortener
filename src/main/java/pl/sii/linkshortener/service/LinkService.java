package pl.sii.linkshortener.service;

import pl.sii.linkshortener.dto.LinkDto;

public interface LinkService {
    LinkDto createLink(LinkDto linkDto);

    String getLink(String id);

    LinkDto getLinkDto(String id);
}
