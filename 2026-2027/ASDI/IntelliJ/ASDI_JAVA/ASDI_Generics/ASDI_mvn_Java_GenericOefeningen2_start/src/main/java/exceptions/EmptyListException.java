package exceptions;

public class EmptyListException extends RuntimeException {

	public EmptyListException() {
        this("List");
    }

	public EmptyListException(String name) {
    	super("%s is empty%n".formatted(name));
    }
}

