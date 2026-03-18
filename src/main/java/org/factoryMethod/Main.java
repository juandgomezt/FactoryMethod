package org.factoryMethod;

import org.factoryMethod.util.ConsolaUI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsolaUI ui    = new ConsolaUI(scanner);
        Cafeteria cafeteria = new Cafeteria(ui);
        cafeteria.atender();
        scanner.close();
    }
}
