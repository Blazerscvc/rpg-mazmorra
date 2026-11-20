# ⚔️ RPG Mazmorra

**RPG de mazmorras con combate automático por equipos, desarrollado en Java.**

RPG Mazmorra es un proyecto personal inspirado en juegos como *Time Walker: Dark World*, donde los personajes combaten automáticamente según sus estadísticas, equipamiento y formación.

El proyecto nace como una iniciativa de aprendizaje para profundizar en **programación orientada a objetos (POO)**, estructuras de datos, arquitectura de software y desarrollo de videojuegos.

El objetivo es construir progresivamente un **MVP jugable**, priorizando las mecánicas fundamentales antes de incorporar sistemas más complejos.

## 🎮 Demostración del combate

Actualmente RPG Mazmorra permite simular enfrentamientos automáticos entre equipos mediante la consola de Java.

Cada combatiente tiene su propia velocidad de ataque y actúa cuando el tiempo simulado alcanza su siguiente ataque. La formación determina qué personajes serán seleccionados primero como objetivos.

**Ejemplo real de un combate 3 vs. 3 (salida abreviada):**

```text
[600 ms] Hunter ataca a Warrior: 7,33 de daño.
[600 ms] Archer ataca a Bandit: 8,57 de daño.
[800 ms] Bandit ataca a Warrior: 10,00 de daño.
[900 ms] Warrior ataca a Bandit: 11,43 de daño.
[1000 ms] Sorcerer ataca a Warrior: 8,67 de daño.
[1000 ms] Mage ataca a Bandit: 10,00 de daño.
...
[8200 ms] Sorcerer ataca a Archer: 10,83 de daño.
[8400 ms] Archer ataca a Sorcerer: 10,91 de daño.
[8900 ms] Archer ataca a Sorcerer: 10,91 de daño.
El ganador es el equipo aliado
```

Los tiempos corresponden a una **simulación**, no a segundos reales de espera. El separador decimal mostrado depende de la configuración regional del sistema.

Se han realizado pruebas manuales de combate 3 vs. 3 con diferentes formaciones. Estas pruebas permitieron comprobar que el orden de los personajes puede influir en la duración del enfrentamiento y en el número de supervivientes.

## 🚀 Cómo ejecutar el proyecto

### Requisitos

- **Java JDK 25:** versión configurada en `pom.xml` y utilizada durante el desarrollo.
- **Apache Maven:** para compilar el proyecto desde la terminal.
- **IntelliJ IDEA:** entorno de desarrollo recomendado, aunque no obligatorio.

### Instalación

**1. Clonar el repositorio**

```bash
git clone https://github.com/Blazerscvc/rpg-mazmorra.git
cd rpg-mazmorra
```

**2. Compilar el proyecto**

```bash
mvn compile
```

**3. Ejecutar el combate**

```bash
java -cp target/classes rpg.main.Main
```

El programa iniciará automáticamente un combate entre dos equipos y mostrará los ataques, el daño efectivo y el equipo ganador en consola.

### Ejecución desde IntelliJ IDEA

También puedes abrir el proyecto en IntelliJ IDEA, permitir que Maven cargue su configuración y ejecutar directamente el método `main()` de:

```text
src/main/java/rpg/main/Main.java
```

## ✅ Funcionalidades implementadas

### Entidades y estadísticas

- Sistema de entidades con vida, resistencia y cálculo de daño.
- Combatientes con estadísticas individuales de fuerza, agilidad, maná y velocidad de ataque.
- Equipos aliados y enemigos.
- Validación de atributos y manejo de residuos de precisión en la vida.

### Armas y equipamiento

- Armas de tipo `PHYSICAL`, `RANGED` y `STAFF`.
- Requisitos de fuerza para equipar armas.
- Sistema de durabilidad, reparación y fragmentación permanente.
- Armas especiales con durabilidad infinita.
- Equipamiento inicial para todos los combatientes.

### Motor de combate automático

- Motor independiente mediante `CombatEngine`.
- Enfrentamientos entre múltiples aliados y enemigos.
- Combates 3 vs. 3 probados manualmente.
- Ataques programados según la velocidad individual.
- Selección de objetivos vivos.
- Detección automática del equipo ganador.
- Registro de ataques y daño efectivo con dos decimales.

### Formaciones automáticas

Los equipos se organizan automáticamente según el tipo de arma equipada.

| Posición      | Tipo de arma | Prioridad |
| ------------- | ------------ | --------- |
| Primera línea | `PHYSICAL`   | 0         |
| Segunda línea | `RANGED`     | 1         |
| Retaguardia   | `STAFF`      | 2         |

Actualmente, cada atacante selecciona al primer combatiente vivo del equipo contrario siguiendo el orden de la formación.

Esto permite que los personajes de primera línea reciban los ataques antes que los de retaguardia.

## 🗺️ Roadmap

### Fase 1 — Fundamentos del combate

- [x] Sistema de entidades y estadísticas.
- [x] Armas y equipamiento.
- [x] Combate automático.
- [x] Combate por equipos.
- [x] Formaciones automáticas.
- [x] Mejorar la presentación de los registros de combate.
- [x] Corregir residuos de precisión en la vida.
- [ ] Incorporar pruebas automatizadas.

### Fase 2 — MVP jugable

- [ ] Preparación del equipo antes del combate.
- [ ] Bloqueo de cambios de equipamiento durante el combate.
- [ ] Habilidades básicas y tiempos de reutilización (*cooldowns*).
- [ ] Exploración sencilla de mazmorras.
- [ ] Progresión básica de personajes.
- [ ] Interfaz gráfica inicial con JavaFX.
- [ ] Ciclo jugable de preparación, combate y recompensa.

### Fase 3 — Expansiones futuras

- Inteligencia artificial con diferentes estrategias de combate.
- Movimiento autónomo en escenarios 2D.
- Formaciones configurables manualmente.
- Inventario, botín y mejoras de equipo.
- Enemigos especiales y jefes.
- Guardado y carga de partidas.
- Nuevas habilidades y especializaciones.

Las funcionalidades y prioridades pueden cambiar conforme evolucione el proyecto.

## 🛠️ Tecnologías

| Tecnología        | Uso                                |
| ----------------- | ---------------------------------- |
| Java 25           | Lógica y desarrollo del juego      |
| Maven             | Compilación y gestión del proyecto |
| IntelliJ IDEA     | Entorno de desarrollo              |
| Git y GitHub      | Control de versiones               |
| JavaFX (previsto) | Futura interfaz gráfica            |

## 📌 Estado actual

**En desarrollo — Prototipo de combate automático funcional.**

Actualmente el proyecto permite ejecutar combates automáticos entre equipos mediante una interfaz de consola.

El sistema cuenta con estadísticas, equipamiento, cálculo de daño, tiempos de ataque individuales, selección de objetivos y formaciones automáticas.

Se han realizado pruebas manuales para comprobar el funcionamiento del motor y corregir problemas detectados durante las simulaciones.

Todavía no existe una suite de pruebas automatizadas.

**RPG Mazmorra aún no es un videojuego completo.** Las mecánicas de exploración, progresión e interacción necesarias para el MVP siguen en desarrollo.

## 📚 Propósito del proyecto

RPG Mazmorra es una iniciativa de aprendizaje personal, no una entrega académica.

El desarrollo se realiza de manera incremental, con el propósito de escribir y comprender personalmente el código, aplicar principios de programación orientada a objetos y adquirir experiencia práctica en la construcción de sistemas de videojuegos.

Se prioriza comprender cada mecánica, probar su funcionamiento y mantener una estructura de código que pueda ampliarse progresivamente.
