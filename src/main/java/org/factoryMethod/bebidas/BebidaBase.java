package org.factoryMethod.bebidas;

import org.factoryMethod.util.Color;

public abstract class BebidaBase implements Bebida {

    protected abstract String[] getLineasResumen();

    protected abstract String[] getPasosPreparacion();

    @Override
    public void mostrarResumen() {
        String c = getColorAnsi();
        Color.separador(c);
        Color.titulo("Tu pedido: " + getNombre(), c);
        Color.separador(c);
        for (String linea : getLineasResumen()) {
            Color.linea(linea, c);
        }
    }

    @Override
    public void preparar() {
        String c = getColorAnsi();
        System.out.println();
        Color.titulo("Preparando...", c);
        for (String paso : getPasosPreparacion()) {
            Color.linea(">> " + paso, c);
        }
        Color.separador(c);
    }
}
