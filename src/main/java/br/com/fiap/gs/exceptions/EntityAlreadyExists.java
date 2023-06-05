package br.com.fiap.gs.exceptions;

public class EntityAlreadyExists extends RuntimeException{
	
	public EntityAlreadyExists() {
		super();
	}

	public EntityAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityAlreadyExists(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityAlreadyExists(String message) {
		super(message);
	}

	public EntityAlreadyExists(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 951534859616974558L;

}
