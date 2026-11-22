package org.example.videoclub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
    String titulo;
    String anio;
    String duracion;
    String copias;
}
