package org.example.videoclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaginaController {

    @GetMapping("/acercaDe")
    public String acercaDe(){
        return "acercaDeVista";
    }

}
