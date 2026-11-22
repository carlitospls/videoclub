package org.example.videoclub.controller;

import jakarta.servlet.http.HttpSession;
import org.example.videoclub.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaginaController {
    int visitasGlobales = 0;

    Pelicula pelicula1 = new Pelicula("La vida es bella", 1988, 180,2);
    Pelicula pelicula2 = new Pelicula("Hulk", 2006, 130,4);
    Pelicula pelicula3 = new Pelicula("Hulk 2", 2009, 140,2);
    Pelicula pelicula4 = new Pelicula("Mortadelo y Filemón", 2012, 120,0);

    List<Pelicula> listDePeliculas = List.of(pelicula1, pelicula2, pelicula3, pelicula4);

    @GetMapping("/acercaDe")
    public String acercaDe(){
        return "acercaDeVista";
    }
    @GetMapping("/videoclub")
    public String inicio(){
        return "videoclub";
    }
    @GetMapping("/")
    public String portada(){
        return "portada";
    }
    @GetMapping("/peliculasRuta")
    public String listaPeliculas(Model model, HttpSession session){

        int visitasIndividuales = (int) session.getAttribute("visitasIndividuales");
        visitasIndividuales += 1;

        visitasGlobales += 1;

        model.addAttribute("peliculas", listDePeliculas);
        model.addAttribute("visitasGlobales", visitasGlobales);
        session.setAttribute("visitasIndividuales", visitasIndividuales);

        return "listaPeliculas";
    }

}
