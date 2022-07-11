package pl.sii.linkshortener.link.api.exception;

public class LinkAlreadyExistException extends RuntimeException {

    public LinkAlreadyExistException(String id) {
        super("Link with " + id + " already exists");
    }
}
