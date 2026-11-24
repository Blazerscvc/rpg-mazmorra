# Programación de ataques

**Estado:** Implementada.

Cada `Combatant` tiene `attackSpeed` positiva y finita. El primer ataque se programa para `1000.0 / attackSpeed` ms; `canAttack(currentTime)` comprueba si se alcanzó `nextAttackTime`. Tras un ataque, `scheduleNextAttack()` añade el intervalo de ataque al instante programado, no al tiempo actual.

Ejemplo: con 2 ataques/s, el intervalo es 500 ms. El motor procesa cada personaje una vez por tick; a velocidades muy altas la resolución de 10 ms limita la frecuencia efectiva. El daño depende del arma y de la resistencia del objetivo; no se usa agilidad o maná todavía.

`resetAttackTime()` restablece el próximo instante a `1000 / attackSpeed`. `initCombat()` llama a `resetTeamAttackTimes()` para ambos equipos. Ver [[Reinicio de temporizadores de ataque]]. La reutilización en una segunda batalla aún no tiene prueba específica registrada.

**Fuente:** `rpg/entities/Combatant.java; rpg/combat/CombatEngine.java`.

## Notas relacionadas

- [[Reloj de simulación]]
- [[Sistema de combate]]
- [[Estadísticas de personajes]]
- [[Selección de objetivos]]
- [[Mitigación de daño]]
