package com.example.ConnectForo_SPA.console;

import com.example.ConnectForo_SPA.services.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;


@Component
public class MenuConsola {
    @Autowired
    private Servicio servicio;
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar");
            System.out.println("2. Iniciar sesion");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    System.out.println("Saliendo");
                    return;
                default:
                    System.out.println("Opcion no valida, intente de nuevo");
            }
        }
    }

    private void registrar() {
        System.out.println("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.println("Ingrese su contraseña");
        String password = scanner.nextLine();   

        boolean exito = servicio.registrarUsuario(username, password, email);
        if (exito) {
            System.out.println("Registrado correctamente");
        } else {
            System.out.println("Error el nombre de usuario ya existe");
        }
    }    

    private void login() {
        System.out.println("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese password: ");
        String password = scanner.nextLine();

        boolean exito = servicio.loginUsuario(username, password);
        if (exito) {
            System.out.println("Login exitoso, bienvenido " + username);
        } else {
            System.out.println("Credeneciales incorrectas.");
        }
    }    
}
