## Estado

✅ Implementado y probado manualmente.

## Objetivo

Organizar automáticamente los combatientes según el tipo de arma equipada, colocando a los personajes físicos en primera línea y a los de rango en posiciones posteriores.

## Prioridades

|Tipo de arma|Prioridad|Posición|
|---|---|---|
|PHYSICAL|0|Primera línea|
|RANGED|1|Segunda línea|
|STAFF|2|Retaguardia|

## Funcionamiento

La clase `CombatEngine` utiliza `Comparator.comparingInt()` para ordenar los `ArrayList<Combatant>` según la prioridad de cada personaje.

El método `getFormationPriority()` determina esa prioridad consultando el tipo de arma equipada.

El método `findLivingTarget()` selecciona al primer combatiente vivo de la lista contraria.

## Experimento realizado

Se probaron dos formaciones con los mismos personajes y estadísticas.

**Prueba 1 — Magos delante**

- Duración: 15 100 ms.
    
- Resultado: victoria aliada.
    
- Supervivientes: 1 aliado.
    

**Prueba 2 — Guerreros delante**

- Duración: 8 900 ms.
    
- Resultado: victoria aliada.
    
- Supervivientes: 2 aliados.
    

**Conclusión:** la formación afectó la duración del combate y la supervivencia de los personajes.

## Decisiones de diseño

- El tipo de arma determina la posición automática.
    
- Las estadísticas determinan la eficacia del personaje.
    
- Se permitirá cambiar armas antes del combate.
    
- Se planea bloquear los cambios de equipamiento durante la batalla.
    

## Mejoras previstas

- Permitir formaciones personalizadas.
    
- Introducir posicionamiento y movimiento en una arena 2D.
    
- Incorporar estrategias de selección de objetivos.
    

## Notas relacionadas

- [[Sistema de combate]]
    
- [[Sistema de armas]]
    
- [[Arquitectura del RPG]]