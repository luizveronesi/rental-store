package com.actionict.inventory.controller;

import com.actionict.inventory.entity.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    @GetMapping
    public List<Film> getAllFilms() { return new ArrayList<Film>(); }
}