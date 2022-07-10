package pl.sii.linkshortener.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(final String url) {
        super("Shortened link " + url + " not found");
    }
}
