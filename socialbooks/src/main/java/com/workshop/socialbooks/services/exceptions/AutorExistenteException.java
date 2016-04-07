package com.workshop.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {

	private static final long serialVersionUID = 7212156727789632218L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}

	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}