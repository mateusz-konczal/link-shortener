package pl.sii.linkshortener.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.sii.linkshortener.link.api.LinkService;

import java.time.LocalDate;

@AllArgsConstructor
@Slf4j
@Component
class CronRemoveExpiredLinks {

    private final LinkService linkService;

    @Scheduled(cron = "${expired.links.cron}")
    void removeExpiredLinks() {
        LocalDate today = LocalDate.now();
        log.info("Started job to remove links");
        linkService.removeExpiredLinks(today);
        log.info("Ended removing links");
    }
}
