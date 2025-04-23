package com.foro.foroapp.Visual;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component

public class ConsolaVisual {
    private final Scanner sc = new Scanner(System.in);
    //funciones simples como mostrar o imprementar un input con un mensaje como ingrese su nombre
    public void mostrar(String mensaje) {
        System.out.println(mensaje);
    }

    public String leer(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }

    public void pausa() {
        System.out.println("Presione ENTER para continuar...");
        sc.nextLine();
    }
}
