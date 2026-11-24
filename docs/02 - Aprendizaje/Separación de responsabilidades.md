# Separación de responsabilidades

**Estado:** Concepto aplicado.

El motor separa preparación, avance, limpieza y anuncio del resultado en initCombat(), advanceTick(), finishCombat() y announceWinner(). startCombat() coordina esos métodos. Las operaciones públicas comprueban sus precondiciones aunque el coordinador también controle el flujo. Combatant solicita el desgaste y Weapon controla sus límites. La siguiente separación consiste en desacoplar la presentación de consola de las reglas.

## Notas relacionadas

- [[Ciclo de vida del combate]]
- [[Registro de combate]]
- [[Desgaste al atacar]]
- [[Encapsulación]]
- [[Conceptos de Java]]
