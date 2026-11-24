# Reloj de simulación

**Estado:** Reloj por instancia y avance independiente implementados; ejecución completa probada en consola.

`CombatEngine` almacena `private double currentTime = 0` y la constante `private static final int TICK_DURATION = 10`. `initCombat()` reinicia el reloj. `advanceTick()` procesa `processTick(currentTime)` y después incrementa el reloj en 10 ms. Los instantes son simulados: no hay espera real entre llamadas.

`processTick(double tiempo)` sigue siendo privado; `advanceTick()` es público y exige RUNNING. `startCombat()` llama a initCombat() y repite advanceTick() mientras RUNNING. JavaFX podrá solicitar avances sin calcular reglas de combate. Con 10 ms, el primer tick que alcanza un instante programado llega con menos de 10 ms de retraso ideal por discretización (sin considerar errores de punto flotante o límites de frecuencia).

Antes se usaba una variable local y pasos de 100 ms. La prueba actual registra el primer ataque de Archer a 560 ms y el último ataque a 8890 ms.

**Fuente:** `rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Programación de ataques]]
- [[Ciclo de vida del combate]]
- [[Variables locales y de instancia]]
- [[Arquitectura del RPG]]
