package pl.sii.linkshortener.service;

import org.springframework.stereotype.Service;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.exception.LinkAlreadyExistException;
import pl.sii.linkshortener.exception.LinkNotFoundException;
import pl.sii.linkshortener.repository.LinkEntity;
import pl.sii.linkshortener.repository.LinkRepository;

import javax.transaction.Transactional;

@Service
class LinkServiceImpl implements LinkService {

    //    private final Map<String, LinkDto> dtoMap = new HashMap<>();
    //    private final CrudRepository<LinkDto, String> repository;
    private final LinkRepository repository;

    LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if (repository.findById(linkDto.getId()).isPresent()) {
            throw new LinkAlreadyExistException(linkDto.getId());
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
}
