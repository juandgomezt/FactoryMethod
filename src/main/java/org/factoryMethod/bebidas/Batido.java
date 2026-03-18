package org.factoryMethod.bebidas;

import org.factoryMethod.util.Color;
import java.util.List;

public class Batido extends BebidaBase {

    private final String tipoLeche;
    private final List<String> frutas;
    private final String tamano;

    public Batido(String tipoLeche, List<String> frutas, String tamano) {
        this.tipoLeche = tipoLeche;
        this.frutas    = frutas;
        this.tamano    = tamano;
    }

    @Override public String getNombre()    { return "Batido"; }
    @Override public String getColorAnsi() { return Color.ROJO; }

    @Override
    protected String[] getLineasResumen() {
        return new String[]{
                "Frutas    : " + String.join(", ", frutas),
                "Leche     : " + tipoLeche,
                "Tamano    : " + tamano,
                "Temperatura: Frio"
        };
    }

    @Override
    protected String[] getPasosPreparacion() {
        return new String[]{
                "Lavando " + String.join(" y ", frutas) + "...",
                "Agregando " + tipoLeche + "...",
                "Licuando hasta obtener consistencia cremosa...",
                "Sirviendo en vaso " + tamano + " bien frio. Listo!"
        };
    }
}
