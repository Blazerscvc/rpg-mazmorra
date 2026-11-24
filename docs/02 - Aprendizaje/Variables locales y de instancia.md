# Variables locales y de instancia

**Estado:** Concepto aplicado.

Una variable local tiene alcance dentro del método o bloque donde se declara. Un atributo de instancia pertenece al objeto y conserva su valor entre llamadas mientras exista. CombatEngine antes tenía un reloj local en startCombat(); ahora `private double currentTime = 0` conserva el tiempo entre llamadas. Un atributo static sería compartido por las instancias y no representa un reloj independiente. La duración fija de un tick sí usa [[Constantes static y final]].

El reloj se reinicia en initCombat() y se incrementa en advanceTick().

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Reloj de simulación]]
- [[Ciclo de vida del combate]]
- [[Encapsulación]]
- [[Conceptos de Java]]
