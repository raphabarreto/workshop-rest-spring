package com.workshop.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.socialbooks.domain.Comentario;

public interface ComentariosRepositoy extends JpaRepository<Comentario, Long>{

}