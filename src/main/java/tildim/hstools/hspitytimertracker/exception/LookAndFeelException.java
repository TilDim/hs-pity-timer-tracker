package tildim.hstools.hspitytimertracker.exception;

import java.io.Serial;

/**
 *
 */
public class LookAndFeelException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5334518612942264729L;

    /**
     * @param message
     * @param cause
     */
    public LookAndFeelException(String message, Throwable cause) {
        super(message, cause);
    }
}
