package pl.sii.linkshortener.repository;

import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<LinkEntity, String> {
}
