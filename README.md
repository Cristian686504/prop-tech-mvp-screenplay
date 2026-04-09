# prop-tech-mvp-screenplay

Pruebas E2E con **Serenity BDD + Screenplay + Cucumber** para el MVP de PropTech. Cubre las historias de usuario:

| HU | Historia | Feature |
|----|----------|---------|
| HU004 | Publicar Propiedad | `hu004_publicar_propiedad.feature` |
| HU005 | Visualizar Propiedades | `hu005_visualizar_propiedades.feature` |

---

## Estructura del proyecto

```
prop-tech-mvp-screenplay/
├── src/
│   ├── main/java/                   # Clases de soporte
│   └── test/
│       ├── java/org/prueba/
│       │   ├── hooks/               # Hooks de Cucumber (Before/After)
│       │   ├── questions/           # Preguntas Screenplay (aserciones)
│       │   ├── runners/
│       │   │   └── CucumberRunner.java  # Runner JUnit 5 + Serenity
│       │   ├── stepdefinitions/     # Step definitions de Cucumber
│       │   ├── tasks/               # Tareas Screenplay (interacciones)
│       │   ├── ui/                  # Page Objects / targets de UI
│       │   └── util/                # Utilidades
│       └── resources/
│           ├── features/
│           │   ├── hu004_publicar_propiedad.feature
│           │   └── hu005_visualizar_propiedades.feature
│           └── serenity.conf        # Configuración de Serenity y WebDriver
├── build.gradle
└── settings.gradle
```

---

## Prerrequisitos

- Java 17+
- Google Chrome instalado
- Backend corriendo en `http://localhost:8080`
- Frontend corriendo en `http://localhost` (configurable en `serenity.conf`)

> Para ejecutar en modo headless, editar `serenity.conf` y establecer `headless.mode = true`.

---

## Comandos para ejecutar las pruebas

### Ejecutar todos los tests (con reporte Serenity)

```bash
./gradlew clean test aggregate
```

### Ejecutar solo los tests (sin regenerar reporte)

```bash
./gradlew clean test
```

### Ejecutar una historia de usuario específica (por tag)

```bash
# HU004 — Publicar Propiedad
./gradlew clean test -Dcucumber.filter.tags="@HU004" aggregate

# HU005 — Visualizar Propiedades
./gradlew clean test -Dcucumber.filter.tags="@HU005" aggregate
```

En Windows:

```bash
gradlew.bat clean test -Dcucumber.filter.tags="@HU004" aggregate
gradlew.bat clean test -Dcucumber.filter.tags="@HU005" aggregate
```

### Ejecutar un caso de prueba específico (por tag TC)

```bash
./gradlew clean test -Dcucumber.filter.tags="@TC-029" aggregate
```

---

## Ver el reporte Serenity

Tras ejecutar los tests, los reportes se generan en:

```
target/site/serenity/index.html          # Reporte completo
target/site/serenity/serenity-summary.html  # Resumen en una página
```
