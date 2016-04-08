package com.workshop.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.workshop.sociabooks.client.LivrosClient;
import com.workshop.sociabooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		LivrosClient client = new LivrosClient("http://localhost:8080", "raphael", "s3nh4");

		List<Livro> listaLivros = client.listar();

		for (Livro livro : listaLivros) {
			System.out.println("Livro:" + livro.getNome());
		}

		Livro livro = new Livro();
		livro.setNome("Começando com primefaces");
		livro.setEditora("Algaworks");

		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2016"));

		livro.setResumo("Este livro aborda como trabalhar com o Git");

		String localizacao = client.salvar(livro);

		System.out.println("URI do livro salvo: " + localizacao);

		Livro livroBuscado = client.buscar(localizacao);

		System.out.println("Livro buscado: " + livroBuscado.getNome());
	}
}