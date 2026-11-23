## Estado

✅ **Implementado y probado manualmente para el MVP.**

## Objetivo

Organizar automáticamente los combatientes según el tipo de arma equipada, colocando a los personajes físicos en primera línea y a los personajes de rango y magia en posiciones posteriores.

La formación determina el orden en el que los personajes aparecen en las listas y, por tanto, influye en la selección de objetivos.

## Prioridades

|Tipo de arma|Prioridad|Posición|
|---|---|---|
|PHYSICAL|0|Primera línea|
|RANGED|1|Segunda línea|
|STAFF|2|Retaguardia|

Cuanto menor sea la prioridad, más adelantado estará el personaje en la formación.

## Funcionamiento

La clase `CombatEngine` utiliza `Comparator.comparingInt()` para ordenar los `ArrayList<Combatant>` de ambos equipos al comenzar la batalla.

### Métodos involucrados

- `**getFormationPriority()**`: determina la prioridad de un personaje consultando el tipo de arma equipada.
    
- `**findLivingTarget()**`: selecciona al primer combatiente vivo del equipo contrario.
    
- `**startCombat()**`: organiza las formaciones antes de comenzar la simulación.
    
- `**processTick()**`: ejecuta los ataques de los personajes que pueden actuar en el instante actual.
    

### Selección de objetivos

Los personajes atacan al primer enemigo vivo de la lista contraria.

Cuando un personaje muere, deja de ser un objetivo válido y el motor selecciona al siguiente combatiente vivo.

**Importante:** actualmente la formación representa un orden lógico de prioridad, no posiciones físicas en una arena 2D.

## Experimento realizado

Se probaron dos formaciones con los mismos personajes y estadísticas.

### Prueba 1 — Magos delante

- Duración: 15 100 ms.
    
- Resultado: victoria aliada.
    
- Supervivientes: 1 aliado.
    

### Prueba 2 — Guerreros delante

- Duración: 8 900 ms.
    
- Resultado: victoria aliada.
    
- Supervivientes: 2 aliados.
    

**Conclusión:** la formación afectó la duración del combate y la supervivencia de los personajes.

Este experimento demuestra que el orden de selección de objetivos puede influir considerablemente en el resultado de una batalla.

## Decisiones de diseño

### Implementadas

- El tipo de arma determina la posición automática del personaje.
    
- Las estadísticas determinan la eficacia de cada combatiente.
    
- Ambos equipos se ordenan antes de comenzar el combate.
    
- Los combatientes pueden cambiar armas antes de iniciar una batalla.
    
- El equipamiento queda bloqueado durante el combate mediante `inCombat`.
    
- Al finalizar, `CombatEngine` desbloquea el equipamiento mediante `finally`.
    

### Consecuencia del sistema de equipamiento

Cambiar el tipo de arma antes del combate puede modificar la prioridad de formación del personaje.

Una vez iniciada la batalla, no se permite cambiar el arma para alterar su posición.

## Mejoras previstas

- Permitir formaciones personalizadas.
    
- Introducir posicionamiento y movimiento en una arena 2D.
    
- Incorporar estrategias de selección de objetivos.
    
- Permitir que determinadas habilidades ataquen posiciones específicas.
    
- Evaluar si algunas armas o habilidades pueden modificar las reglas de selección de objetivos.
    

Estas funcionalidades no forman parte del MVP actual.

## Notas relacionadas

- [[Sistema de combate]]
    
- [[Sistema de armas]]
    
- [[Arquitectura del RPG]]