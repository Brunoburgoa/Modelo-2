package org.example.entidades;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class UnidadMedida {
    private Long id;
    private String denominacion;
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
}