package com.example.filmscrud.service;

import com.example.filmscrud.model.Film;
import com.example.filmscrud.model.Language;
import com.example.filmscrud.repository.FilmRepository;
import com.example.filmscrud.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id).orElse(null);
    }

    public void saveFilm(Film film) {
        filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
}
