package App;

import Model.Producto;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Optional;

import static java.util.Arrays.stream;

public class AppStreams {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String categoriaBuscada = null;
        double precioBuscado = 0;

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

        System.out.println("\nRepaso Java - Guía 2 - Progrmación funcional");
        System.out.println("\n--- Ejercicios ---");
        System.out.println("1. Mostrar productos con precio superior a elegido.");
        System.out.println("2. Obtener lista de nombres de productos por categoria.");
        System.out.println("3. Buscar productos más barato por categoría.");
        System.out.println("4. Mostrar total de productos en el almacen.");
        System.out.println("5. Mostrar si todos los productos tienen stock.");

        System.out.println("\nElija un ejercicio: ");
        switch (scanner.nextInt()) {
            case 1:
                System.out.println("--- Ejercicio 1 ---");
                System.out.println("Ingrese precio: ");
                precioBuscado = scanner.nextDouble();
                double precioFinal = precioBuscado;
                productos.stream().filter(producto -> producto.getPrecio() > precioFinal).forEach(System.out::println);
                break;

            case 2:
                System.out.println("--- Ejercicio 2 ---");
                System.out.println("Ingrese categoria: ");
                categoriaBuscada = scanner.next();
                String finalCategoria1 = categoriaBuscada;
                List<String> productosPorCategoria = productos.stream().filter(producto -> producto.getCategoria().equals(finalCategoria1)).map(Producto::getNombre).toList();
                if (!productosPorCategoria.isEmpty()) {
                    productosPorCategoria.forEach(System.out::println);
                } else {
                    System.out.println("No hay productos disponibles.");
                }
                break;

            case 3:
                System.out.println("--- Ejercicio 3 ---");
                System.out.println("Ingrese categoria: ");
                categoriaBuscada = scanner.next();
                String finalCategoria2 = categoriaBuscada;
                Optional<Producto> optionalProducto = productos.stream().filter(producto -> producto.getCategoria().equals(finalCategoria2)).min((p1, p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()));
                if (optionalProducto.isPresent()) {
                    System.out.println(optionalProducto.get());
                } else {
                    System.out.println("No hay productos disponibles");
                }
                break;

            case 4:
                System.out.println("--- Ejercicio 4 ---");
                System.out.println("Total de productos en el almacen: " + productos.stream().mapToInt(Producto::getStock).sum());
                break;

            case 5:
                System.out.println("--- Ejercicio 5 ---");
                boolean stockDisponible = productos.stream().allMatch(producto -> producto.getStock() > 0);
                if (stockDisponible) {
                    System.out.println("Todos los productos tienen stock.");
                }
                else {
                    System.out.println("No todos los productos tienen stock disponible.");
                }
                break;

            default:
                System.out.println("Opcion inválida");
                break;
        }


    }
}