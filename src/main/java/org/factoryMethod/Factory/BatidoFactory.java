package org.factoryMethod.Factory;

import org.factoryMethod.bebidas.Batido;
import org.factoryMethod.bebidas.Bebida;
import org.factoryMethod.util.Color;
import org.factoryMethod.util.ConsolaUI;

import java.util.ArrayList;
import java.util.List;

public class BatidoFactory extends BebidaFactory {

    private static final String[] LECHES = {
            "Leche entera", "Leche descremada", "Leche de almendra", "Leche de coco"
    };
    private static final String[] FRUTAS_OPCIONES  = {
            "Fresa", "Banano", "Mango", "Mora", "Melon", "Durazno"
    };
    private static final String[] TAMANOS           = { "Pequeno", "Mediano", "Grande" };
    private static final String[] OPCIONES_CANTIDAD = { "Una fruta", "Dos frutas", "Tres frutas" };

    @Override
    public Bebida crearBebida(ConsolaUI ui) {
        String leche       = ui.elegirOpcion("Tipo de leche:", Color.ROJO, LECHES);
        List<String> frutas = elegirFrutas(ui);
        String tamano      = ui.elegirOpcion("Tamano:",        Color.ROJO, TAMANOS);
        return new Batido(leche, frutas, tamano);
    }

    private List<String> elegirFrutas(ConsolaUI ui) {
        String cantidadStr = ui.elegirOpcion(
                "Cuantas frutas quieres?", Color.ROJO, OPCIONES_CANTIDAD);

        int cantidad = switch (cantidadStr) {
            case "Una fruta"  -> 1;
            case "Dos frutas" -> 2;
            default           -> 3;
        };

        List<String> elegidas    = new ArrayList<>();
        List<String> disponibles = new ArrayList<>(List.of(FRUTAS_OPCIONES));

        for (int i = 0; i < cantidad; i++) {
            String fruta = ui.elegirOpcion(
                    "Elige fruta " + (i + 1) + ":",
                    Color.ROJO,
                    disponibles.toArray(new String[0]));
            elegidas.add(fruta);
            disponibles.remove(fruta);
        }
        return elegidas;
    }
}
