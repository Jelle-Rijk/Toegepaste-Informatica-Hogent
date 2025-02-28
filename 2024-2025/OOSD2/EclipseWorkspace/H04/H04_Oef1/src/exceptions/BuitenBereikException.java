package exceptions;

public class BuitenBereikException extends IllegalArgumentException {
//	CONSTRUCTORS
	public BuitenBereikException() {
		super();
	}

	public BuitenBereikException(String message) {
		super(message);
	}

	public BuitenBereikException(Throwable cause) {
		super(cause);
	}

	public BuitenBereikException(String message, Throwable cause) {
		super(message, cause);
	}
}
