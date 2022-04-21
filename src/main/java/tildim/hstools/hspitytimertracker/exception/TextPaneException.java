package tildim.hstools.hspitytimertracker.exception;

import java.io.Serial;

/**
 *
 */
public class TextPaneException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1903426377047206772L;

    /**
     * @param message
     * @param cause
     */
    public TextPaneException(String message, Throwable cause) {
        super(message, cause);
    }
}
