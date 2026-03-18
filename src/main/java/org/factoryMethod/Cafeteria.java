package org.factoryMethod;

import org.factoryMethod.Factory.BatidoFactory;
import org.factoryMethod.Factory.BebidaFactory;
import org.factoryMethod.Factory.CafeFactory;
import org.factoryMethod.Factory.JugoFactory;
import org.factoryMethod.util.Color;
import org.factoryMethod.util.ConsolaUI;

public class Cafeteria {

    private static final String[] MENU_OPCIONES = {
            "Jugo Natural", "Cafe", "Batido"
    };

    private final ConsolaUI ui;

    public Cafeteria(ConsolaUI ui) {
        this.ui = ui;
    }

    public void atender() {
        mostrarBienvenida();

        boolean continuar = true;
        while (continuar) {
            String opcion    = ui.elegirOpcion(
                    "Que bebida deseas ordenar?", Color.AZUL, MENU_OPCIONES);
            BebidaFactory fabrica = seleccionarFabrica(opcion);
            fabrica.servirBebida(ui);
            continuar = ui.preguntarSiNo("Ordenar otra bebida?");
        }

        mostrarDespedida();
    }

    private BebidaFactory seleccionarFabrica(String opcion) {
        return switch (opcion) {
            case "Jugo Natural" -> new JugoFactory();
            case "Cafe"         -> new CafeFactory();
            case "Batido"       -> new BatidoFactory();
            default -> throw new IllegalArgumentException("Opcion desconocida: " + opcion);
        };
    }

    private void mostrarBienvenida() {
        System.out.println();
        Color.separador(Color.VERDE);
        Color.titulo("FACTORY METHOD", Color.VERDE);
        Color.titulo("Cafeteria de Bebidas",  Color.VERDE);
        Color.separador(Color.VERDE);
    }

    private void mostrarDespedida() {
        System.out.println();
        Color.separador(Color.VERDE);
        Color.titulo("Gracias por tu orden. Hasta pronto!", Color.VERDE);
        Color.separador(Color.VERDE);
        System.out.println();
    }
}
