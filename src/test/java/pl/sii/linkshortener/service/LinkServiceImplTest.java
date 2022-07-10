package pl.sii.linkshortener.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sii.linkshortener.dto.LinkDto;
import pl.sii.linkshortener.exception.LinkAlreadyExistException;
import pl.sii.linkshortener.exception.LinkNotFoundException;
import pl.sii.linkshortener.repository.LinkEntity;
import pl.sii.linkshortener.repository.LinkRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class LinkServiceImplTest {

    @Mock
    LinkRepository repository;

    @InjectMocks
    LinkServiceImpl linkService;

    @Test
    void shouldNotCreateShortenedLinkInCaseOfOccupiedIdentifier() {
//        // Given
//        LinkService linkService = new LinkServiceImpl();
//        LinkDto linkDto = new LinkDto("some ID", "test@email.com", "https://google.com", null, 0);
//        linkService.createLink(linkDto);
//
//        // When
//        //linkService.createLink(new LinkDto("some ID", "email@test.pl", "https://bing.com", null, 1));
//        Assertions.assertThrows(LinkAlreadyExistException.class, () -> linkService.createLink(new LinkDto(
//                "some ID", "test@email.com", "https://google.com", null, 0)));

        // Given
        LinkDto linkDto = new LinkDto("damian", "test@gmail.com", "google.com", LocalDate.now(), 0);
        given(repository.findById("damian")).willReturn(Optional.of(LinkEntity.fromDto(linkDto)));
        //Then
        Assertions.assertThrows(LinkAlreadyExistException.class,
                () -> linkService.createLink(new LinkDto("damian", "t@gmail.com", "amazon.com", LocalDate.now(), 0)));
    }

    @Test
    void shouldThrowLinkNotFoundExceptionInCaseOfLinkNotFound() {
        // Given
        String id = "test";
        given(repository.findById(id)).willReturn(Optional.empty());
        // Then
        Assertions.assertThrows(LinkNotFoundException.class,
                () -> linkService.getLink(id));
    }

    @Test
    void shouldIncrementVisitsNumberOnEntry() {
        // Given
        String id = "test";

    }

}