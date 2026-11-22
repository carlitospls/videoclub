package org.example.videoclub.controller;

import jakarta.servlet.http.HttpSession;
import org.example.videoclub.model.Pelicula;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.List;

@Controller
public class PaginaController {
    int visitasGlobales = 0;

    LocalTime horaGlobal = LocalTime.now().withNano(0);

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

        Integer visitasIndividuales = (Integer) session.getAttribute("visitasIndividuales");
        LocalTime horaVisitaInvididual = LocalTime.now().withNano(0);


        if (visitasIndividuales == null){
            visitasIndividuales = 0;
        }

        visitasIndividuales += 1;

        visitasGlobales += 1;


        model.addAttribute("peliculas", listDePeliculas);
        model.addAttribute("visitasGlobales", visitasGlobales);
        model.addAttribute("visitasIndividuales", visitasIndividuales);
        model.addAttribute("primeraVisita", horaVisitaInvididual);
        model.addAttribute("horaGlobal", horaGlobal);
        model.addAttribute("ultimaVisita", horaGlobal);
        session.setAttribute("primeraVisita", horaVisitaInvididual);
        session.setAttribute("visitasIndividuales", visitasIndividuales);

        return "listaPeliculas";
    }

}
