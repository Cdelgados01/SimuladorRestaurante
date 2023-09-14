
package com.mycompany.restaurante;

import com.google.cloud.firestore.Firestore;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Restaurante {

    public static void main(String[] args) {
        Conexion.conectarFirebase();
        FirebaseDataManager dataManager = new FirebaseDataManager(Conexion.db);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        String nombreCliente = "";
        
       
        do {
        
            if(nombreCliente.isEmpty()){
                System.out.println("Ingrese su nombre: ");
                nombreCliente = scanner.nextLine();
            }
        
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Sushi");
            System.out.println("2. Hamburguesa");
            System.out.println("3. Pizza");
            System.out.println("4. Historial");
            System.out.println("5. Salir");

            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt(); // Obtener la opción del usuario
            
            Map<String, Object> datosAgregar = new HashMap<>();
            datosAgregar.put("cliente", nombreCliente);
            
            switch (opcion) {
                case 1:
                    // Menu 2
                    datosAgregar.put("comida", "Sushi");
                    datosAgregar.put("precio", 12000);
                    System.out.println("Ingrese el nombre del cliente: ");
                    dataManager.agregarDatos("miColeccion", "miDocumento", datosAgregar);
                    System.out.println("Datos agregados exitosamente.");
                    break;
                case 2:
                    // Menu 2
                    datosAgregar.put("comida", "Hamburguesa");
                    datosAgregar.put("precio", 10000);
                    dataManager.agregarDatos("miColeccion", "miDocumento", datosAgregar);
                    System.out.println("Datos agregados exitosamente.");
                    break;
                case 3:
                    // Menu 2
                    datosAgregar.put("comida", "Pizza");
                    datosAgregar.put("precio", 4000);
                    dataManager.agregarDatos("miColeccion", "miDocumento", datosAgregar);
                    System.out.println("Datos agregados exitosamente.");
                    break;
                case 4:
                    // Obtener datos
                    Menu menuRecuperado = (Menu) dataManager.obtenerDatos("miColeccion", "miDocumento", Menu.class);
                    if (menuRecuperado != null) {
                        System.out.println("Los datos almacenados son:");
                        System.out.println("Nombre del cliente: " + menuRecuperado.getCliente());
                        System.out.println("Precio de la comida: " + menuRecuperado.getPrecio());
                        System.out.println("Comida del cliente: " + menuRecuperado.getComida());
                    } else {
                        System.out.println("El documento no se encontró.");
                    }
                    break;
                case 5:
                    // Salir del programa
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
}
