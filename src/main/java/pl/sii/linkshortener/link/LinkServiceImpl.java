package pl.sii.linkshortener.link;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sii.linkshortener.link.api.LinkDto;
import pl.sii.linkshortener.link.api.exception.LinkAlreadyExistException;
import pl.sii.linkshortener.link.api.exception.LinkNotFoundException;
import pl.sii.linkshortener.link.api.LinkService;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Slf4j
class LinkServiceImpl implements LinkService {

    //    private final Map<String, LinkDto> dtoMap = new HashMap<>();
    //    private final CrudRepository<LinkDto, String> repository;
    private final LinkRepository repository;

    LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if (repository.findById(linkDto.id()).isPresent()) {
            throw new LinkAlreadyExistException(linkDto.id());
        }
        repository.save(LinkEntity.fromDto(linkDto));

        return linkDto;
    }

    @Override
    @Transactional
    public String getLink(String id) {
        LinkEntity linkEntity = repository.findById(id).orElseThrow(() -> new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits() + 1); // można to dodać do klasy LinkEntity
        return linkEntity.getTargetUrl();

//        return repository
//                .findById(id)
//                .orElseThrow(() -> new LinkNotFoundException(id))
//                .getTargetUrl();

//        if (repository.findById(id).isEmpty()) {
//            throw new LinkNotFoundException(id);
//        } else {
//            return repository.findById(id).get().getTargetUrl();
//        }
    }

    @Override
    public LinkDto getLinkDto(String id) {
        return repository.findById(id).orElseThrow(() -> new LinkNotFoundException(id)).toDto();
    }

    @Override
    @Transactional
    public void removeExpiredLinks(LocalDate date) {
        var expiredLinks = repository.findLinksBeforeDate(date);
        repository.deleteAll(expiredLinks);
        expiredLinks.forEach(linkEntity -> log.info("deleted entity with id " + linkEntity.getId()));
//        log.info((long) expiredLinks.size() + " items with time expiration before " + date + " has been deleted.");
    }
}
