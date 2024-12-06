package com.example.filmscrud.repository;

import com.example.filmscrud.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    // JpaRepository ya incluye métodos como findAll(), save(), etc.
}
