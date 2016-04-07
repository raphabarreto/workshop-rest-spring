package com.workshop.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.socialbooks.domain.Autor;

public interface AutoresRepository extends JpaRepository<Autor, Long>{

}
