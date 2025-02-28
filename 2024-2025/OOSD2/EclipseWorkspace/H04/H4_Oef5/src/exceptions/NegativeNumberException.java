package exceptions;

public class NegativeNumberException extends Exception {
	public NegativeNumberException() {
		super();
	}

	public NegativeNumberException(String message) {
		super(message);
	}

	public NegativeNumberException(Throwable cause) {
		super(cause);
	}

	public NegativeNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
