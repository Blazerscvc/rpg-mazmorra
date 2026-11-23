# ⚔️ RPG Mazmorra — Centro de desarrollo

> RPG de mazmorras con combate automático, desarrollado en Java.

**Estado:** 🟢 Prototipo de combate funcional en consola.

**Objetivo principal:** Completar un MVP jugable con combate automático, preparación de personajes, exploración básica y una interfaz gráfica mediante JavaFX.

**Filosofía de desarrollo:** Aprender programación Java escribiendo y comprendiendo personalmente el código.

---

## 📚 Wiki del proyecto

Documentación técnica de los sistemas implementados:

- [[Sistema de combate]]
    
- [[Sistema de armas]]
    
- [[Formaciones automáticas]]
    

**Documentación pendiente:**

- [[Arquitectura del RPG]] — Nota por desarrollar.
    

Las notas técnicas deben reflejar el comportamiento real del código y distinguir claramente las funcionalidades implementadas de las ideas futuras.

---

## 🎯 Objetivo actual

**Preparar** `**CombatEngine**` **para ejecutar el combate mediante ticks independientes y facilitar su integración con JavaFX.**

### Próximas tareas

- Convertir el reloj simulado en un atributo de `CombatEngine`.
    
- Separar el inicio, avance y finalización del combate.
    
- Implementar `advanceTick()` para procesar un tick por llamada.
    
- Conservar la ejecución automática de batallas por consola.
    
- Adaptar la gestión de `CombatState` al nuevo ciclo de vida.
    
- Separar los registros de consola de la lógica del motor.
    
- Crear una primera representación gráfica sencilla con JavaFX.
    

### Prioridades posteriores del MVP

- Diseñar la preparación de personajes antes de combatir.
    
- Implementar un inventario básico.
    
- Incorporar una exploración sencilla de mazmorras.
    
- Conectar las mecánicas principales en un ciclo de juego funcional.
    

---

## ✅ Avances completados

### Sistema de personajes

- Entidades y estadísticas.
    
- Sistema de salud y resistencia.
    
- Velocidades de ataque individuales.
    
- Cálculo de daño y reducción mediante resistencia.
    

### Sistema de armas

- Armas con estadísticas y requisitos.
    
- Equipamiento según la fuerza del personaje.
    
- Durabilidad y reparación.
    
- Fragmentación permanente de armas rotas.
    
- Penalización de daño para armas rotas.
    
- Armas especiales con durabilidad infinita.
    
- Bloqueo de equipamiento durante el combate.
    

### Sistema de combate

- Combate automático entre equipos.
    
- Simulación de enfrentamientos 3 vs. 3.
    
- Formaciones automáticas según el tipo de arma.
    
- Selección del primer objetivo vivo según la formación.
    
- Procesamiento de ataques mediante `processTick()`.
    
- Simulación con incrementos de 100 ms.
    
- Máquina de estados `CombatState`.
    
- Validación para impedir ejecutar nuevamente un combate finalizado.
    
- Gestión del bloqueo de equipamiento mediante `try/finally`.
    
- Registro de ataques con dos decimales.
    
- Determinación del equipo ganador.
    

### Correcciones realizadas

- Corrección de residuos decimales en los puntos de vida.
    
- Corrección de un error de recursión en `isInCombat()`.
    
- Verificación del desbloqueo del equipamiento al finalizar.
    

---

## 🧪 Pruebas realizadas

### Combate 3 vs. 3

**Equipo aliado:** Warrior, Archer y Mage.

**Equipo enemigo:** Bandit, Hunter y Sorcerer.

**Resultado:** victoria del equipo aliado.

**Último ataque registrado:** 8900 ms.

### Máquina de estados

- Estado inicial: `READY`.
    
- Estado durante la ejecución: `RUNNING`.
    
- Estado después del combate: `FINISHED`.
    
- Una segunda ejecución del mismo combate produce `IllegalStateException`.
    

### Sistema de equipamiento

Se comprobó que el cambio de arma se rechaza durante el combate y vuelve a permitirse cuando `inCombat` es `false`.

**Nota:** las pruebas actuales son principalmente manuales. Queda pendiente incorporar pruebas automatizadas.

---

## 🏗️ Decisiones de arquitectura

- `CombatEngine` controla las reglas y el tiempo simulado del combate.
    
- JavaFX será responsable de representar visualmente el estado del juego.
    
- La lógica del combate debe funcionar independientemente de la interfaz.
    
- El código Java es la fuente de verdad sobre las funcionalidades existentes.
    
- Se prioriza una arquitectura sencilla y funcional antes de incorporar sistemas complejos.
    

---

## 🐛 Limitaciones conocidas

- `startCombat()` todavía ejecuta todos los ticks mediante un `while`.
    
- El motor aún no permite avanzar un tick por llamada pública.
    
- `CombatState.FINISHED` no distingue una batalla completada de una interrumpida por errores.
    
- `setInCombat()` todavía permite modificaciones externas del estado.
    
- Los mensajes de combate siguen vinculados a `System.out`.
    
- El sistema no cuenta todavía con pruebas automatizadas completas.
    

---

## 💡 Ideas futuras

Las ideas nuevas se registran primero en `raw/` para evitar distraernos del MVP.

Entre las ideas futuras están:

- Enemigos con mecánicas de corrupción.
    
- Habilidades especiales.
    
- Estrategias avanzadas de selección de objetivos.
    
- Formaciones personalizadas.
    
- Arena de combate 2D.
    
- Sistemas de progresión y equipamiento más avanzados.
    

Estas ideas no deben confundirse con funcionalidades implementadas.

---

## 🔗 Repositorio

[GitHub — RPG Mazmorra](https://github.com/Blazerscvc/rpg-mazmorra)

La documentación técnica se almacena en `docs/wiki/` y se versiona junto al proyecto.

Las instrucciones locales de Gemini se encuentran en `GEMINI.md` y están excluidas del repositorio público.

---

## 📌 Reglas de desarrollo

1. Priorizar un MVP jugable antes de añadir mecánicas complejas.
    
2. Escribir y comprender personalmente el código Java.
    
3. Utilizar la IA como tutor, no como sustituto del aprendizaje.
    
4. Probar las funcionalidades antes de marcarlas como completadas.
    
5. Mantener Obsidian sincronizado con los avances reales.
    
6. Registrar los cambios importantes mediante Git.
    
7. Evitar refactorizaciones y funcionalidades que no aporten valor al objetivo actual.