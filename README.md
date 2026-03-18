# Patrón Creacional: Factory Method
## Cafetería de Bebidas

---

## ¿Qué es?
Patrón creacional que define una interfaz para crear objetos,
pero deja que las **subclases decidan qué clase concreta instanciar**.
El cliente nunca usa `new` directamente sobre los productos.

---

## ¿Para qué sirve?
- Cuando no sabes de antemano qué tipo de objeto necesitas crear.
- Cuando quieres que las subclases controlen qué objeto se instancia.
- Para evitar `if/else` o `switch` para crear objetos.
- Para que agregar un nuevo tipo **no rompa el código existente**.

**Ejemplo:** una cafetería que prepara Café, Jugo o Batido.
Cada bebida se crea diferente, pero el cliente solo dice
"quiero una bebida" y la fábrica correcta se encarga del resto.

---

## ¿Cómo funciona? (Guía paso a paso)

**1. Defines el producto como clase abstracta**
```java
public abstract class Bebida {
    public abstract String getNombre();
    public abstract void preparar();
}
```

**2. Creas los productos concretos**
```java
public class Cafe extends BebidaBase {
    public String getNombre() { return "Cafe"; }
    public void preparar() { /* pasos para hacer café */ }
}
```

**3. Defines la fábrica abstracta con el Factory Method**
```java
public abstract class BebidaFactory {
    public abstract Bebida crearBebida(); // <- FACTORY METHOD
    public void servirBebida() {
        Bebida b = crearBebida();         // usa la abstracción
        b.preparar();
    }
}
```

**4. Cada fábrica concreta decide qué objeto crear**
```java
public class CafeFactory extends BebidaFactory {
    public Bebida crearBebida() {
        return new Cafe();  // <- decide aquí
    }
}
```

**5. El cliente usa la fábrica sin saber qué objeto se crea**
```java
BebidaFactory fabrica = new CafeFactory();
fabrica.servirBebida(); // no sabe que es un Cafe
```

## Estructura de paquetes
```
src/main/java/org/factoryMethod/
├── Main.java                        <- cliente, demuestra el patrón
├── Cafeteria.java                   <- orquesta el flujo
├── util/
│   └── Color.java                   <- colores ANSI para la consola
├── bebidas/
│   ├── Bebida.java                  <- producto abstracto
│   ├── BebidaBase.java              <- implementación base
│   ├── Cafe.java                    <- producto concreto
│   ├── Jugo.java                    <- producto concreto
│   └── Batido.java                  <- producto concreto
└── factory/
    ├── BebidaFactory.java           <- creador abstracto (Factory Method)
    ├── CafeFactory.java             <- creador concreto
    ├── JugoFactory.java             <- creador concreto
    └── BatidoFactory.java           <- creador concreto
```

---

## Cómo extender el patrón

Para agregar una nueva bebida (p.ej. **Té**):

1. Crear `Te.java` en `bebidas/` extendiendo `BebidaBase`
2. Crear `TeFactory.java` en `factory/` extendiendo `BebidaFactory`
3. Usarla en `Main` igual que las demás

**No se modifica ninguna clase existente** — esto es OCP en acción.

## Referencias
- https://refactoring.guru/es/design-patterns/factory-method
