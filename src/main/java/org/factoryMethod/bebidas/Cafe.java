package org.factoryMethod.bebidas;

import org.factoryMethod.Factory.CafeFactory;
import org.factoryMethod.util.Color;

public class Cafe extends BebidaBase {

    private final String tipoLeche;
    private final String azucar;
    private final String tamano;

    public Cafe(String tipoLeche, String azucar, String tamano) {
        this.tipoLeche = tipoLeche;
        this.azucar    = azucar;
        this.tamano    = tamano;
    }

    @Override public String getNombre()    { return "Cafe"; }
    @Override public String getColorAnsi() { return Color.MORADO; }

    @Override
    protected String[] getLineasResumen() {
        return new String[]{
                "Leche     : " + tipoLeche,
                "Azucar    : " + azucar,
                "Tamano    : " + tamano,
                "Temperatura: Caliente"
        };
    }

    @Override
    protected String[] getPasosPreparacion() {

        String pasoLeche = CafeFactory.CAFE_NEGRO.equals(tipoLeche)
                ? "Preparando cafe negro puro..."
                : "Calentando " + tipoLeche + "...";

        return new String[]{
                "Moliendo granos de cafe frescos...",
                "Extrayendo espresso a 90 grados...",
                pasoLeche,
                "Agregando " + azucar + "...",
                "Sirviendo en taza " + tamano + ". Listo!"
        };
    }
}
