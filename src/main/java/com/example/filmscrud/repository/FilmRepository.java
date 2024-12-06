package com.example.filmscrud.repository;

import com.example.filmscrud.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    // JpaRepository ya incluye métodos como findAll(), save(), etc.
}
