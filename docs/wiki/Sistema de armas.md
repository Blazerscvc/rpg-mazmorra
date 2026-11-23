## Estado

✅ **Mecánicas principales implementadas y probadas manualmente.**

El sistema de armas continúa en desarrollo, pero las funcionalidades principales necesarias para el MVP ya están implementadas.

## Objetivo

Permitir que los combatientes utilicen diferentes armas, cada una con sus propias estadísticas, requisitos y reglas de durabilidad.

Las armas influyen en el daño causado, el equipamiento permitido y la posición automática de los personajes en combate.

## Funcionamiento actual

Las armas están representadas mediante la clase `Weapon`.

Cada arma tiene:

- **Nombre (**`**name**`**):** identifica el arma.
    
- **Daño (**`**damage**`**):** cantidad de daño base que puede causar.
    
- **Durabilidad (**`**durability**`**):** resistencia actual del arma al desgaste.
    
- **Durabilidad máxima (**`**maxDurability**`**):** límite de durabilidad.
    
- **Fuerza requerida (**`**reqStrength**`**):** fuerza mínima necesaria para equiparla.
    
- **Tipo (**`**TypeWeapon**`**):** determina su categoría y prioridad de formación.
    

### Tipos de armas

|Tipo|Función actual|
|---|---|
|`PHYSICAL`|Armas físicas, primera línea|
|`RANGED`|Armas de rango, segunda línea|
|`STAFF`|Bastones, retaguardia|

## Mecánicas implementadas

### 1. Equipamiento

Los personajes equipan armas mediante `equipWeapon()` de la clase `Combatant`.

El equipamiento se rechaza cuando:

- El personaje no cumple el requisito de fuerza.
    
- El personaje está participando en un combate.
    

Si se rechaza el cambio, el personaje conserva su arma anterior.

### 2. Durabilidad

Las armas normales poseen durabilidad limitada.

Los métodos principales son:

- `reduceDurability()`: reduce la durabilidad del arma.
    
- `repair()`: permite reparar un arma bajo las condiciones establecidas.
    
- `isBroken()`: comprueba si el arma está rota.
    

La durabilidad no puede superar su valor máximo.

### 3. Fragmentación permanente

Cuando la durabilidad llega a cero, el arma se considera rota permanentemente.

Una vez rota:

- Su nombre mostrado adopta el formato `Shard of <nombre original>`.
    
- Su daño efectivo se reduce un 90 %.
    
- No puede repararse.
    
- No puede renombrarse.
    

La fragmentación representa una penalización permanente del arma.

### 4. Armas especiales

La clase `SpecialWeapon` representa armas con reglas especiales de durabilidad.

Actualmente:

- Poseen durabilidad infinita.
    
- No se fragmentan por desgaste.
    
- Están excluidas del renombrado mediante el yunque.
    

### 5. Bloqueo de equipamiento durante el combate

La clase `Combatant` posee el atributo `inCombat`.

- `true`: impide cambiar el arma.
    
- `false`: permite cambiarla si cumple los requisitos.
    

`CombatEngine` activa el bloqueo al iniciar la batalla y lo desactiva al finalizar.

Se utiliza `try/finally` para restablecer el estado de equipamiento incluso si ocurre una excepción.

## Validaciones

El sistema comprueba los valores utilizados al crear y modificar armas.

Entre las validaciones implementadas están:

- Nombres válidos.
    
- Daño no negativo y finito para armas normales.
    
- Durabilidad máxima no negativa y válida.
    
- Requisitos de fuerza no negativos.
    
- Restricciones para modificar armas rotas.
    

## Pruebas realizadas

### Bloqueo de equipamiento

- Warrior intenta equipar `Long Bow` durante el combate: conserva `Iron Sword`.
    
- Warrior intenta equipar `Long Bow` fuera del combate: cambio permitido.
    
- Al finalizar el combate, `isInCombat()` devuelve `false`.
    

**Resultado:** el bloqueo funciona según las pruebas realizadas.

## Relación con otros sistemas

### [[Sistema de combate]]

Las armas determinan el daño base utilizado durante los ataques.

El estado de combate controla cuándo puede modificarse el equipamiento.

### [[Formaciones automáticas]]

El tipo de arma equipada determina la prioridad de formación.

Cambiar un arma antes del combate puede modificar la posición automática del personaje.

## Próximas mejoras

- Mejorar la encapsulación del estado `inCombat`.
    
- Integrar el equipamiento con un futuro inventario.
    
- Incorporar habilidades y efectos especiales de armas.
    
- Diseñar una interfaz para consultar y equipar armas mediante JavaFX.
    
- Integrar las mecánicas de durabilidad con las futuras funcionalidades del juego.
    

Estas mejoras quedan pendientes y no forman parte de las funcionalidades ya verificadas.

## Notas relacionadas

- [[Sistema de combate]]
    
- [[Formaciones automáticas]]