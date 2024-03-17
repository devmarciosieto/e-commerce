package br.com.mmmsieto.order.domain.exceptions;

import java.util.List;

public class DomainException extends NoStacktraceException {

    protected final List<Error> errors;

    protected DomainException(final String aMessage, final List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final String aMessage, final Error anErrors) {
        return new DomainException(aMessage, List.of(anErrors));
    }

    public static DomainException with(final String message, final List<Error> anErrors) {
        return new DomainException(message, anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }
}
