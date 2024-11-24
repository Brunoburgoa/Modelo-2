package org.example.entidades;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Imagen {
    private long id;
    private String denominacion;
    private Articulo Articulo;
    private Promocion Promocion;
}
