package com.workshop.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 7212156727789632218L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}