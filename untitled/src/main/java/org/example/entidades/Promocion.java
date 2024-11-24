package org.example.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Promocion {
    private long id;
    private String denominacion;
    private LocalDate FechaDesde;
    private LocalDate FechaHasta;
    private LocalTime HoraDesde;
    private LocalTime HoraHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion TipoPromocion;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
}
