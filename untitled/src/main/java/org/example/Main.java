package org.example;

import org.example.entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Crear Unidades de Medida
        UnidadMedida ochoPorciones = UnidadMedida.builder()
                .id(1L)
                .denominacion("8 Porciones")
                .build();
        UnidadMedida cuatroPorciones = UnidadMedida.builder()
                .id(2L)
                .denominacion("4 Porciones")
                .build();
        UnidadMedida unLitro = UnidadMedida.builder()
                .id(3L)
                .denominacion("1 Litro")
                .build();

        // Crear Imágenes
        Imagen imagen1 = Imagen.builder().id(1L).denominacion("Pizza Grande Hawaiana").build();
        Imagen imagen2 = Imagen.builder().id(2L).denominacion("Pizza Grande Napolitana").build();
        Imagen imagen3 = Imagen.builder().id(3L).denominacion("Pizza Grande Muzza").build();
        Imagen imagen4 = Imagen.builder().id(4L).denominacion("Pizza Chica Hawaiana").build();
        Imagen imagen5 = Imagen.builder().id(5L).denominacion("Pizza Chica Napolitana").build();
        Imagen imagen6 = Imagen.builder().id(6L).denominacion("Pizza Chica Muzza").build();
        Imagen imagen7 = Imagen.builder().id(7L).denominacion("Cerveza Andes").build();
        Imagen imagen8 = Imagen.builder().id(8L).denominacion("Cerveza Quilmes").build();

        // Crear Artículos
        Articulo cerveza1 = Articulo.builder()
                .id(1L)
                .denominacion("Cerveza Andes")
                .precioVenta(100d)
                .precioCompra(80d)
                .stockActual(10)
                .stockMaximo(25)
                .imagen(imagen7)
                .build();

        Articulo cerveza2 = Articulo.builder()
                .id(2L)
                .denominacion("Cerveza Quilmes")
                .precioVenta(90d)
                .precioCompra(50d)
                .stockActual(20)
                .stockMaximo(30)
                .imagen(imagen8)
                .build();

        Articulo pizza1 = Articulo.builder()
                .id(3L)
                .denominacion("Pizza Grande Hawaiana")
                .precioVenta(150d)
                .precioCompra(120d)
                .stockActual(15)
                .stockMaximo(20)
                .imagen(imagen1)
                .build();

        Articulo pizza2 = Articulo.builder()
                .id(4L)
                .denominacion("Pizza Chica Hawaiana")
                .precioVenta(100d)
                .precioCompra(80d)
                .stockActual(10)
                .stockMaximo(15)
                .imagen(imagen4)
                .build();

        Articulo pizza3 = Articulo.builder()
                .id(5L)
                .denominacion("Pizza Grande Napolitana")
                .precioVenta(130d)
                .precioCompra(110d)
                .stockActual(20)
                .stockMaximo(25)
                .imagen(imagen2)
                .build();

        Articulo pizza4 = Articulo.builder()
                .id(6L)
                .denominacion("Pizza Chica Napolitana")
                .precioVenta(90d)
                .precioCompra(70d)
                .stockActual(10)
                .stockMaximo(15)
                .imagen(imagen5)
                .build();

        Articulo pizza5 = Articulo.builder()
                .id(7L)
                .denominacion("Pizza Grande Muzza")
                .precioVenta(140d)
                .precioCompra(100d)
                .stockActual(10)
                .stockMaximo(20)
                .imagen(imagen3)
                .build();

        Articulo pizza6 = Articulo.builder()
                .id(8L)
                .denominacion("Pizza Chica Muzza")
                .precioVenta(80d)
                .precioCompra(60d)
                .stockActual(5)
                .stockMaximo(10)
                .imagen(imagen6)
                .build();

        // Crear Promociones
        Promocion happyHour = Promocion.builder()
                .id(1L)
                .denominacion("Happy Hour")
                .FechaDesde(LocalDate.of(2023, 9, 1))
                .FechaHasta(LocalDate.of(2023, 12, 31))
                .HoraDesde(LocalTime.of(17, 0))
                .HoraHasta(LocalTime.of(20, 0))
                .descripcionDescuento("Descuento en pizzas y cervezas")
                .precioPromocional(250d)
                .TipoPromocion(TipoPromocion.happyHour)
                .build();
        happyHour.getArticulos().addAll(List.of(pizza1, pizza5, cerveza2));
        happyHour.getImagenes().addAll(List.of(imagen1, imagen3, imagen8));

        Promocion verano = Promocion.builder()
                .id(2L)
                .denominacion("Verano")
                .FechaDesde(LocalDate.of(2023, 12, 1))
                .FechaHasta(LocalDate.of(2024, 2, 28))
                .HoraDesde(LocalTime.of(12, 0))
                .HoraHasta(LocalTime.of(15, 0))
                .descripcionDescuento("Promoción para días de calor")
                .precioPromocional(300d)
                .TipoPromocion(TipoPromocion.Verano)
                .build();
        verano.getArticulos().addAll(List.of(pizza2, pizza3, cerveza1, cerveza2));
        verano.getImagenes().addAll(List.of(imagen4, imagen2, imagen7, imagen8));

        Promocion invierno = Promocion.builder()
                .id(3L)
                .denominacion("Invierno")
                .FechaDesde(LocalDate.of(2023, 6, 1))
                .FechaHasta(LocalDate.of(2023, 8, 31))
                .HoraDesde(LocalTime.of(18, 0))
                .HoraHasta(LocalTime.of(21, 0))
                .descripcionDescuento("Ideal para días fríos")
                .precioPromocional(200d)
                .TipoPromocion(TipoPromocion.Invierno)
                .build();
        invierno.getArticulos().addAll(List.of(pizza1, pizza6, cerveza2));
        invierno.getImagenes().addAll(List.of(imagen1, imagen6, imagen8));

        List<Promocion> promociones = List.of(happyHour, verano, invierno);

        // a. Mostrar todas las promociones:
        System.out.println("a. Mostrar todas las promociones:");
        promociones.forEach(promocion -> {
            System.out.println("\nPromoción: " + promocion.getDenominacion());
            System.out.println("Descripción: " + promocion.getDescripcionDescuento());
            System.out.println("Precio Promocional: $" + promocion.getPrecioPromocional());
            System.out.println("Desde: " + promocion.getFechaDesde() + " Hasta: " + promocion.getFechaHasta());
            System.out.println("Horario: " + promocion.getHoraDesde() + " a " + promocion.getHoraHasta());
            System.out.println("Artículos: ");
            promocion.getArticulos().forEach(articulo -> System.out.println("  - " + articulo.getDenominacion()));
        });

        List<Articulo> articulos = List.of(cerveza1, cerveza2, pizza1, pizza2, pizza3, pizza4, pizza5, pizza6);

        System.out.println("\nb. Mostrar todos los artículos:");
        String encabezado = "ID  | Denominación           | Precio Venta | Precio Compra | Stock Actual | Stock Máximo | Imagen";
        System.out.println(encabezado);

        // Mostrar los artículos
        articulos.forEach(articulo -> {
            String id = String.valueOf(articulo.getId());
            String denominacion = articulo.getDenominacion();
            String precioVenta = String.valueOf(articulo.getPrecioVenta());
            String precioCompra = String.valueOf(articulo.getPrecioCompra());
            String stockActual = String.valueOf(articulo.getStockActual());
            String stockMaximo = String.valueOf(articulo.getStockMaximo());
            String imagen = articulo.getImagen().getDenominacion();

            // Asegurar que todos los campos estén alineados
            System.out.println(
                    id + completarEspacios(id, 4)+ "|" +
                            denominacion + completarEspacios(denominacion, 24)+ "|" +
                            precioVenta + completarEspacios(precioVenta, 14)+ "|" +
                            precioCompra + completarEspacios(precioCompra, 15)+ "|" +
                            stockActual + completarEspacios(stockActual, 14)+ "|" +
                            stockMaximo + completarEspacios(stockMaximo, 14)+ "|" +
                            imagen);
        });

        // c. Mostrar cada promoción por separado los artículos relacionados y el precio de venta:
        System.out.println("\nc. Mostrar cada promoción por separado y los artículos relacionados:");
        promociones.forEach(promocion -> {
            System.out.println("\nPromoción: " + promocion.getDenominacion());
            promocion.getArticulos().forEach(articulo ->
                    System.out.println("  - Artículo: " + articulo.getDenominacion() + " | Precio de Venta: $" + articulo.getPrecioVenta()));
        });

        // d. Mostrar día y horario de la promoción Verano:
        System.out.println("\nd. Mostrar el día y horario de la promoción Verano:");
        Promocion promocionVerano = promociones.stream()
                .filter(promocion -> promocion.getDenominacion().equals("Verano"))
                .findFirst()
                .orElse(null);
        if (promocionVerano != null) {
            System.out.println("Promoción Verano: Desde " + promocionVerano.getFechaDesde() +
                    " hasta " + promocionVerano.getFechaHasta() +
                    " Horario: " + promocionVerano.getHoraDesde() + " a " + promocionVerano.getHoraHasta());
        }

        // e. Mostrar promoción más económica:
        System.out.println("\ne. Mostrar cuál es la promoción más económica de las 3:");
        Promocion promocionMasEconomica = promociones.stream()
                .min(Comparator.comparing(Promocion::getPrecioPromocional))
                .orElse(null);
        if (promocionMasEconomica != null) {
            System.out.println("La promoción más económica es: " + promocionMasEconomica.getDenominacion() +
                    " con un precio de $" + promocionMasEconomica.getPrecioPromocional());
        }
    }
    public static String completarEspacios(String nombreComponente, int num) {
        int espaciosNum = num - nombreComponente.length();
        StringBuilder espacios = new StringBuilder();
        for (int i = 0; i < espaciosNum; i++) {
            espacios.append(" ");
        }
        return espacios.toString();
    }
}
