package io.github.talmeidas.battle.core.exception;

import java.io.Serial;

public class InvalidActionException extends CoreException {

    @Serial
    private static final long serialVersionUID = -6738656739101162231L;

    public InvalidActionException(final String message, final Object... args) {
        super(message, args);
    }
}
