package pl.sii.linkshortener.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.exception.LinkAlreadyExistException;

import java.util.HashMap;
import java.util.Map;

@Service
class LinkServiceImpl implements LinkService {

    private final Map<String, LinkDto> dtoMap = new HashMap<>();

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if (dtoMap.get(linkDto.getId()) != null) {
            throw new LinkAlreadyExistException(linkDto.getId());
        }
        dtoMap.put(linkDto.getId(), linkDto);
        return linkDto;
    }

    @Override
    public String getLink(String id) {
        return dtoMap.get(id).getTargetUrl();
    }
}
