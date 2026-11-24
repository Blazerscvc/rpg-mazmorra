# Pruebas de combate

**Estado:** Resultados manuales históricos; pruebas automatizadas pendientes.

## Combate 3 vs. 3
Warrior, Archer y Mage contra Bandit, Hunter y Sorcerer. Victoria aliada; último ataque registrado a 8900 ms.

## Formaciones
Magos delante: 15 100 ms, victoria aliada, un superviviente aliado. Guerreros delante: 8 900 ms, victoria aliada, dos supervivientes. Mismos personajes y estadísticas según la nota histórica.

## Estado y equipamiento
Se observó READY antes del combate, RUNNING durante la ejecución y FINISHED al finalizar; un segundo inicio lanzó IllegalStateException. Warrior conservó Iron Sword al intentar equipar Long Bow con inCombat activo; fuera de combate pudo cambiarlo. Se corrigió la recursión accidental de isInCombat().

## Ejecución refactorizada (24/11/2026)
Escenario 3 vs. 3 con resolución de 10 ms: primer ataque de Archer a 560 ms, último ataque a 8890 ms, victoria aliada y código de salida 0. El registro de IntelliJ confirma la ejecución de startCombat() hasta su fin normal. No muestra valores de durabilidad ni prueba por separado el avance externo o la reutilización de combatientes.

## Pendientes
Pruebas JUnit, tipo de arma nulo (corrección escrita, ejecución específica no registrada), fin de combate por excepción, equipos vacíos, llamadas externas a ticks independientes, reutilización en otra batalla y prueba aislada del desgaste y fragmentación. Estos resultados se conservan de las notas previas; no se ejecutaron nuevamente en esta reorganización.

**Fuente:** `Notas anteriores; rpg/main/Main.java como escenario de ejemplo`.

## Notas relacionadas

- [[Sistema de combate]]
- [[Formaciones automáticas]]
- [[Máquina de estados del combate]]
- [[Bloqueo de equipamiento]]
- [[Validaciones de armas]]

- [[Casos pendientes]]
