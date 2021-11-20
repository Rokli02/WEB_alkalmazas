package hu.me.iit.webalk.tree.service.exceptions;

import hu.me.iit.webalk.tree.service.Tree;

public class CanNotUpdateNotExistingElementException extends RuntimeException {

	public CanNotUpdateNotExistingElementException() {
		super();
	}

	public CanNotUpdateNotExistingElementException(String message) {
		super(message);
	}
	
	public CanNotUpdateNotExistingElementException(Tree tree) {
		super(String.format("Can not update %s, because element with id: %d not exists", tree.getName(), tree.getId()));
	}

	
}
