package pl.sii.linkshortener.service;

import org.springframework.stereotype.Service;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.exception.LinkAlreadyExistException;
import pl.sii.linkshortener.exception.LinkNotFoundException;
import pl.sii.linkshortener.repository.Repository;

@Service
class LinkServiceImpl implements LinkService {

    //    private final Map<String, LinkDto> dtoMap = new HashMap<>();
    //    private final CrudRepository<LinkDto, String> repository;
    private final Repository repository;

    LinkServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public LinkDto createLink(LinkDto linkDto) {
        if (repository.findById(linkDto.getId()).isPresent()) {
            throw new LinkAlreadyExistException(linkDto.getId());
        }
        repository.save(linkDto.getId(), linkDto);

        return repository.findById(linkDto.getId()).get();
    }

    @Override
    public String getLink(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id))
                .getTargetUrl();

//        if (repository.findById(id).isEmpty()) {
//            throw new LinkNotFoundException(id);
//        } else {
//            return repository.findById(id).get().getTargetUrl();
//        }
    }
}
