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
    private String titulo;
    private Integer anio;
    private Integer duracion;
    private Integer copias;
}
