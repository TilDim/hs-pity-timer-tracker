package tildim.hstools.hspitytimertracker.exception;

import java.io.Serial;

/**
 *
 */
public class TextFileException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 7358195713997421836L;

    /**
     * @param message
     * @param cause
     */
    public TextFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
