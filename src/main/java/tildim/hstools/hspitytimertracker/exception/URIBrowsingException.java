package tildim.hstools.hspitytimertracker.exception;

import java.io.Serial;

/**
 *
 */
public class URIBrowsingException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1763130662822115558L;

    /**
     * @param message
     * @param cause
     */
    public URIBrowsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
