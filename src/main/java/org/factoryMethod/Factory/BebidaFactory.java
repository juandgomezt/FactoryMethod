package org.factoryMethod.Factory;

import org.factoryMethod.bebidas.Bebida;
import org.factoryMethod.util.Color;
import org.factoryMethod.util.ConsolaUI;

public abstract class BebidaFactory {

    /**
     * FACTORY METHOD — punto de extensión del patrón.
     * Cada subclase implementa este método para crear
     * su bebida concreta con las opciones que el usuario elija.
     *
     * @param ui interfaz de consola para interactuar con el usuario
     * @return la bebida personalizada creada
     */
    public abstract Bebida crearBebida(ConsolaUI ui);

    /**
     * Llama al factory method y usa el resultado solo a través
     * de la interfaz Bebida (DIP).
     *
     * @param ui interfaz de consola para interactuar con el usuario
     */
    public void servirBebida(ConsolaUI ui) {
        Bebida bebida = crearBebida(ui);
        bebida.mostrarResumen();
        bebida.preparar();
        System.out.println(Color.VERDE + Color.NEGRITA
                + "  Bebida lista! Que la disfrutes :)"
                + Color.RESET);
        System.out.println();
    }
}
