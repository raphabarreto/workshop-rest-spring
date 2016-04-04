package com.workshop.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long> {

}