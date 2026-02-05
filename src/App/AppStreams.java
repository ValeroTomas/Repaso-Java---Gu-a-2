package App;

import Model.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppStreams {
    public static void main(String[] args) {
        // Base de datos simulada
        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", "Tech", 1200.00, 10),
                new Producto("Mouse", "Tech", 25.00, 50),
                new Producto("Teclado", "Tech", 45.00, 30),
                new Producto("Silla", "Hogar", 150.00, 5),
                new Producto("Escritorio", "Hogar", 300.00, 2),
                new Producto("Monitor", "Tech", 200.00, 0), // Sin stock
                new Producto("Auriculares", "Tech", 50.00, 15)
        );

        System.out.println("--- Ejercicio 1 ---");
        List<Producto> productosCaros = productos.stream().filter(producto -> producto.getPrecio() > 50).toList();
        System.out.println(productosCaros );

        System.out.println("--- Ejercicio 2 ---");

    }
}