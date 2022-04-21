package tildim.hstools.hspitytimertracker.exception;

import java.io.Serial;

/**
 *
 */
public class IconCreationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -9159740899370844256L;

    /**
     * @param message
     * @param cause
     */
    public IconCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
