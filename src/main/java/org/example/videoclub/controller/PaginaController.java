package org.example.videoclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

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

}
