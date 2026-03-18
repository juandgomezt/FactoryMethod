package org.factoryMethod.Factory;

import org.factoryMethod.bebidas.Bebida;
import org.factoryMethod.bebidas.Jugo;
import org.factoryMethod.util.Color;
import org.factoryMethod.util.ConsolaUI;

import java.util.ArrayList;
import java.util.List;

public class JugoFactory extends BebidaFactory {

    private static final String[] FRUTAS_OPCIONES = {
            "Naranja", "Mango", "Fresa", "Pina", "Maracuya", "Guanabana"
    };
    private static final String[] TAMANOS          = { "Pequeno", "Mediano", "Grande" };
    private static final String[] OPCIONES_CANTIDAD = { "Una fruta", "Dos frutas", "Tres frutas" };

    @Override
    public Bebida crearBebida(ConsolaUI ui) {
        List<String> frutas = elegirFrutas(ui);
        String tamano = ui.elegirOpcion("Elige el tamano:", Color.AMARILLO, TAMANOS);
        return new Jugo(frutas, tamano);
    }

    private List<String> elegirFrutas(ConsolaUI ui) {
        String cantidadStr = ui.elegirOpcion(
                "Cuantas frutas quieres combinar?", Color.AMARILLO, OPCIONES_CANTIDAD);

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
                    Color.AMARILLO,
                    disponibles.toArray(new String[0]));
            elegidas.add(fruta);
            disponibles.remove(fruta);
        }
        return elegidas;
    }
}
