package org.factoryMethod.util;

import java.util.Scanner;

public class ConsolaUI {

    private final Scanner scanner;

    public ConsolaUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public String elegirOpcion(String pregunta, String color, String[] opciones) {
        System.out.println(color + "\n  " + pregunta + Color.RESET);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(color + "    [" + (i + 1) + "] " + opciones[i] + Color.RESET);
        }
        while (true) {
            System.out.print(color + "  Opcion: " + Color.RESET);
            String entrada = scanner.nextLine().trim();
            try {
                int numero = Integer.parseInt(entrada);
                if (numero >= 1 && numero <= opciones.length) {
                    return opciones[numero - 1];
                }
            } catch (NumberFormatException ignorada) {
                
            }
            System.out.println(Color.ROJO
                    + "  ERROR: Elige un numero entre 1 y " + opciones.length + "."
                    + Color.RESET);
        }
    }

    public boolean preguntarSiNo(String pregunta) {
        while (true) {
            System.out.print(Color.AZUL + "  " + pregunta + " (s/n): " + Color.RESET);
            String resp = scanner.nextLine().trim().toLowerCase();
            if (resp.equals("s")) return true;
            if (resp.equals("n")) return false;
            System.out.println(Color.ROJO + "  Respuesta invalida. Escribe 's' o 'n'." + Color.RESET);
        }
    }
}
