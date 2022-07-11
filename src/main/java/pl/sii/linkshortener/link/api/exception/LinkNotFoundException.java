package pl.sii.linkshortener.link.api.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(final String url) {
        super("Shortened link " + url + " not found");
    }
}
