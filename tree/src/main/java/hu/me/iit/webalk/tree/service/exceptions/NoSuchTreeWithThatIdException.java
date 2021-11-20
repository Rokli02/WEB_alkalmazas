package hu.me.iit.webalk.tree.service.exceptions;

public class NoSuchTreeWithThatIdException extends RuntimeException {

	public NoSuchTreeWithThatIdException() {
	}

	public NoSuchTreeWithThatIdException(Long id) {
		super(String.format("Tree with id: %d, is not exists in the system!", id));
	}

	public NoSuchTreeWithThatIdException(String message) {
		super(message);
	}
	
	

	
}
