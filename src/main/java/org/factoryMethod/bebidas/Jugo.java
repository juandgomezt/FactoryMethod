package org.factoryMethod.bebidas;

import org.factoryMethod.util.Color;
import java.util.List;

public class Jugo extends BebidaBase {

    private final List<String> frutas;
    private final String tamano;

    public Jugo(List<String> frutas, String tamano) {
        this.frutas = frutas;
        this.tamano = tamano;
    }

    @Override public String getNombre()    { return "Jugo Natural"; }
    @Override public String getColorAnsi() { return Color.AMARILLO; }

    @Override
    protected String[] getLineasResumen() {
        return new String[]{
                "Frutas    : " + String.join(", ", frutas),
                "Tamano    : " + tamano,
                "Temperatura: Frio con hielo"
        };
    }

    @Override
    protected String[] getPasosPreparacion() {
        return new String[]{
                "Lavando " + String.join(" y ", frutas) + "...",
                "Cortando y exprimiendo las frutas...",
                "Sirviendo en vaso " + tamano + " con hielo. Listo!"
        };
    }
}
