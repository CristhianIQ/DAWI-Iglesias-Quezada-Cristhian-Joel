package com.example.filmscrud.controller;

import com.example.filmscrud.model.Film;
import com.example.filmscrud.service.FilmService;
import com.example.filmscrud.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // Mostrar todas las películas
    @GetMapping
    public String listFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "film/list";  // Vista con la lista de películas
    }

    // Ver detalles de una película
    @GetMapping("/view/{id}")
    public String viewFilm(@PathVariable("id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "film/view";  // Vista con los detalles de la película
    }

    // Mostrar formulario para registrar una nueva película
    @GetMapping("/new")
    public String showFormForAdd(Model model) {
        Film film = new Film();
        List<Language> languages = filmService.getAllLanguages();
        model.addAttribute("film", film);
        model.addAttribute("languages", languages);
        return "film/form";  // Vista para registrar una nueva película
    }

    // Guardar nueva película
    @PostMapping
    public String saveFilm(@ModelAttribute("film") Film film) {
        filmService.saveFilm(film);
        return "redirect:/films";  // Redirigir a la lista de películas
    }

    // Mostrar formulario para editar una película
    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        Film film = filmService.getFilmById(id);
        List<Language> languages = filmService.getAllLanguages();
        model.addAttribute("film", film);
        model.addAttribute("languages", languages);
        return "film/form";  // Vista para editar la película
    }

    // Eliminar una película
    @GetMapping("/delete/{id}")
    public String deleteFilm(@PathVariable("id") Long id) {
        filmService.deleteFilm(id);
        return "redirect:/films";  // Redirigir a la lista de películas después de eliminar
    }
}
