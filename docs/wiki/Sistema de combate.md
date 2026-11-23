# Sistema de combate

## Estado

✅ **Funcional en consola y probado manualmente.**

El sistema de combate automático está implementado para enfrentamientos entre equipos. Actualmente se está preparando su arquitectura para una futura integración con JavaFX.

## Descripción

RPG Mazmorra utiliza un sistema de combate automático entre equipos de aliados y enemigos.

La clase `CombatEngine` coordina los enfrentamientos, controla las reglas de combate y determina cuándo termina la batalla.

El objetivo arquitectónico es mantener la lógica del juego independiente de su representación visual.

## Funcionamiento actual

- Los equipos están representados mediante `ArrayList<Combatant>`.
    
- Cada personaje tiene estadísticas y velocidad de ataque individuales.
    
- Los combatientes se organizan automáticamente según el tipo de arma equipada.
    
- Los objetivos se seleccionan según el orden de formación.
    
- El tiempo avanza en intervalos simulados de 100 ms.
    
- Los ataques se ejecutan cuando `canAttack(tiempo)` lo permite.
    
- El combate termina cuando un equipo pierde todos sus combatientes.
    

## Arquitectura de CombatEngine

### startCombat()

Es el método principal que coordina actualmente la batalla.

Sus responsabilidades incluyen:

1. Comprobar que el combate se encuentre en estado `READY`.
    
2. Ordenar las formaciones de ambos equipos.
    
3. Activar el bloqueo de equipamiento.
    
4. Cambiar el estado a `RUNNING`.
    
5. Ejecutar la simulación hasta que termine la batalla.
    
6. Desbloquear el equipamiento.
    
7. Establecer el estado `FINISHED`.
    
8. Anunciar el equipo ganador cuando la ejecución termina normalmente y existe un equipo superviviente.
    

### processTick(double tiempo)

Procesa los ataques correspondientes a un instante de la simulación.

Actualmente:

- Recorre primero el equipo enemigo.
    
- Recorre después el equipo aliado.
    
- Comprueba si cada personaje está vivo y puede atacar.
    
- Busca un objetivo válido.
    
- Ejecuta el ataque y actualiza el próximo tiempo de ataque.
    
- Registra las acciones en consola.
    

Este método permite separar parcialmente la lógica de los ataques de la coordinación general del combate.

**Limitación actual:** `startCombat()` todavía utiliza un `while` para ejecutar todos los ticks consecutivamente. No existe aún una operación pública que permita avanzar un solo tick por llamada.

## Máquina de estados

Se implementó el enum `CombatState`:

|Estado|Significado|
|---|---|
|`READY`|El combate está preparado para iniciar.|
|`RUNNING`|El combate se encuentra en ejecución.|
|`FINISHED`|La ejecución del combate ha terminado.|

`CombatEngine` almacena el estado en un atributo privado:

`private CombatState state = CombatState.READY;`

El método `getState()` permite consultar su valor.

### Validación de inicio

`startCombat()` solamente puede ejecutarse cuando el estado es `READY`.

Si se intenta iniciar nuevamente una batalla que ya está ejecutándose o finalizó, el motor lanza una `IllegalStateException`.

### Finalización

El motor utiliza `try/finally` para desbloquear el equipamiento y establecer el estado `FINISHED`.

**Limitación:** actualmente `FINISHED` también se establece si ocurre una excepción durante el combate. Todavía no existe un estado independiente para representar una interrupción inesperada.

## Sistema de tiempo y ataques

Cada combatiente posee una velocidad de ataque individual y un próximo instante programado para atacar.

Los métodos principales son:

- `canAttack(tiempo)`: comprueba si el personaje puede realizar un ataque.
    
- `attack(target)`: ejecuta el ataque contra el objetivo.
    
- `scheduleNextAttack()`: programa el siguiente instante de ataque.
    

El motor utiliza un reloj simulado que avanza de 100 en 100 ms.

Actualmente, `tiempo` es una variable local de `startCombat()`.

## Selección de objetivos

Los personajes se organizan por prioridad:

1. `PHYSICAL`: primera línea.
    
2. `RANGED`: segunda línea.
    
3. `STAFF`: retaguardia.
    

El método `findLivingTarget()` selecciona al primer combatiente vivo del equipo contrario.

Por ahora, la formación es lógica y no representa posiciones físicas en una arena.

## Bloqueo de equipamiento

Durante el combate, todos los participantes tienen `inCombat = true`.

Esto impide que `equipWeapon()` cambie el arma equipada.

Al finalizar la ejecución, el motor restablece `inCombat = false` mediante `setTeamCombatState()`.

El bloque `finally` protege esta limpieza cuando ocurre una excepción.

## Pruebas realizadas

### Combate automático 3 vs. 3

- Equipo aliado: Warrior, Archer y Mage.
    
- Equipo enemigo: Bandit, Hunter y Sorcerer.
    
- Último ataque registrado: 8900 ms.
    
- Resultado: victoria del equipo aliado.
    
- El programa terminó normalmente.
    

### Máquina de estados

- Estado inicial: `READY`.
    
- Estado después de ejecutar `startCombat()`: `FINISHED`.
    
- Segundo intento de iniciar el mismo combate: `IllegalStateException`.
    

### Equipamiento

- Se comprobó que `inCombat` se activa durante el combate.
    
- Se comprobó que vuelve a `false` al finalizar.
    
- Se verificó que el cambio de arma es rechazado cuando el combatiente está en batalla.
    

## Decisiones de diseño

- `CombatEngine` será responsable de las reglas y del tiempo simulado.
    
- JavaFX representará visualmente el estado del combate.
    
- La interfaz no determinará el daño ni las reglas de ataque.
    
- El motor debe poder funcionar independientemente de JavaFX.
    
- Se priorizará conservar el comportamiento actual mientras se refactoriza.
    

## Próximas mejoras

### Prioridad actual

- Convertir el reloj simulado en un atributo de `CombatEngine`.
    
- Separar el inicio, el avance de ticks y la finalización de la batalla.
    
- Implementar `advanceTick()` para avanzar un tick por llamada.
    
- Mantener la posibilidad de ejecutar batallas completas por consola.
    
- Adaptar la gestión de estados y la limpieza del equipamiento al nuevo ciclo de vida.
    

### Mejoras posteriores

- Separar los mensajes de consola de los eventos del motor.
    
- Preparar la integración visual con JavaFX.
    
- Incorporar habilidades y efectos de combate.
    
- Implementar estrategias avanzadas de selección de objetivos.
    
- Distinguir las batallas completadas de las interrumpidas por errores.
    

## Notas relacionadas

- [[Sistema de armas]]
    
- [[Formaciones automáticas]]
    
- [[Arquitectura del RPG]]