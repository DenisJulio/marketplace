package com.denisjulio.marketplace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.denisjulio.marketplace.repositories.AnuncioRepository;

@Controller
public class AnuncioController {

    private AnuncioRepository anuncioRepository;

    public AnuncioController(AnuncioRepository anuncioRepository) {
        this.anuncioRepository = anuncioRepository;
    }

    @GetMapping("/")
    public String getPaginaAnuncios(Model model) {
        var anuncios = anuncioRepository.findAll();
        model.addAttribute("anuncios", anuncios);
        return "index";
    }

    @GetMapping("/anuncios/{anuncioId}")
    public String getMethodName(@PathVariable Integer anuncioId, Model model) {
        var anuncio = anuncioRepository.findById(anuncioId).orElseThrow();
        model.addAttribute("anuncio", anuncio);
        return "detalhes-anuncio";
    }
}
