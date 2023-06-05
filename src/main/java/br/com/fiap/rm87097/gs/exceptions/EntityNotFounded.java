package br.com.fiap.rm87097.gs.exceptions;

public class EntityNotFounded extends RuntimeException{
	
	public EntityNotFounded() {
		super();
	}

	public EntityNotFounded(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotFounded(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFounded(String message) {
		super(message);
	}

	public EntityNotFounded(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 951534859616974558L;

}
