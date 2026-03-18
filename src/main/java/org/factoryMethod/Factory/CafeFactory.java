package org.factoryMethod.Factory;

import org.factoryMethod.bebidas.Bebida;
import org.factoryMethod.bebidas.Cafe;
import org.factoryMethod.util.Color;
import org.factoryMethod.util.ConsolaUI;


public class CafeFactory extends BebidaFactory {

    public static final String CAFE_NEGRO = "Sin leche (negro)";

    private static final String[] LECHES  = {
            CAFE_NEGRO, "Leche entera", "Leche de almendra", "Leche de avena"
    };
    private static final String[] AZUCARES = {
            "Sin azucar", "Poca azucar", "Normal", "Extra dulce"
    };
    private static final String[] TAMANOS  = { "Pequeno", "Mediano", "Grande" };

    @Override
    public Bebida crearBebida(ConsolaUI ui) {
        String c = Color.MORADO;
        String leche  = ui.elegirOpcion("Tipo de leche:",      c, LECHES);
        String azucar = ui.elegirOpcion("Cantidad de azucar:", c, AZUCARES);
        String tamano = ui.elegirOpcion("Tamano:",             c, TAMANOS);
        return new Cafe(leche, azucar, tamano);
    }
}
