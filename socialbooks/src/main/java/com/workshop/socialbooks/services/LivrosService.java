package com.workshop.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.socialbooks.domain.Comentario;
import com.workshop.socialbooks.domain.Livro;
import com.workshop.socialbooks.repository.ComentariosRepositoy;
import com.workshop.socialbooks.repository.LivrosRepository;
import com.workshop.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;

	@Autowired
	private ComentariosRepositoy comentariosRepositoy;

	public List<Livro> listar() {
		return livrosRepository.findAll();
	}

	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findOne(id);

		if (livro == null) {
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
		}
		return livro;
	}

	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);
	}

	public void deletar(Long id) {
		this.buscar(id);
		livrosRepository.delete(id);
	}

	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}

	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}

	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		return comentariosRepositoy.save(comentario);
	}

	public List<Comentario> listarComentarios(Long livroId) {
		Livro livro = buscar(livroId);
		return livro.getComentarios();
	}
}