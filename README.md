## Kotlin Learning Course (kotlinlang.org)

This repository tracks my hands-on progress following the Kotlin language course from kotlinlang.org. The goal is to become productive using Kotlin as a backend developer (Kotlin/JVM) and as an Android developer.

### Goals
- Learn Kotlin language fundamentals thoroughly
- Practice Kotlin idioms and the standard library
- Apply Kotlin on the server with JVM frameworks (e.g., Ktor, Spring Boot)
- Build Android apps with modern Android/Kotlin tools (Jetpack, Compose)

### Prerequisites
- JDK 17+ installed and on PATH
- IDE: IntelliJ IDEA (recommended) or Android Studio for Android parts
- Gradle Wrapper is included; no global Gradle install required

### Project Structure
- `src/main/kotlin/` — language exercises and examples
  - `basictypes.kt`, `classes.kt`, `collections.kt`, `control_flow.kt`, `firstcode.kt`, `functions.kt`, `lambda_expressions﻿.kt`
- `build.gradle.kts`, `settings.gradle.kts` — Gradle build scripts
- `gradlew`, `gradlew.bat`, `gradle/` — Gradle Wrapper

### How to build (Windows PowerShell)
```bash
./gradlew.bat build
```

Other useful commands:
```bash
./gradlew.bat clean
./gradlew.bat tasks
```

### Running code
These sources are a collection of small, topic-focused files. The easiest way to run a specific example is via IntelliJ IDEA:
- Open the repo in IntelliJ
- Open any `*.kt` file with a `main` function
- Click the gutter run icon to execute

If you prefer Gradle-based runs for a single entry point, add the Application plugin and set the `mainClass` to the file that contains `main` (e.g., `MainKt`). Example configuration to add in `build.gradle.kts` (not required just to build):
```kotlin
plugins {
    application
}

application {
    // Replace with your actual main class (e.g., package.MainKt)
    mainClass.set("MainKt")
}
```
Then run:
```bash
./gradlew.bat run
```

### Backend learning path (Kotlin/JVM)
- Language mastery: collections, null-safety, coroutines, flows
- Build a small HTTP API with Ktor
- Add persistence (Exposed/SQLDelight/JPA) and testing (JUnit + MockK)
- Explore structured concurrency and channels for async workloads
- Packaging and deployment as a fat JAR or Docker image

### Android learning path
- Android Studio + Kotlin
- Jetpack Compose UI fundamentals
- Architecture: MVVM, ViewModel, StateFlow, Kotlin Coroutines
- Data layer: Room/SQLDelight, Retrofit/Ktor Client
- Navigation, theming, and app lifecycle
- Testing: unit tests and UI tests (Espresso/Compose testing)

### Helpful links
- Kotlin docs: `https://kotlinlang.org/docs/home.html`
- Kotlin Koans (exercises): `https://play.kotlinlang.org/koans/overview`
- Coroutines guide: `https://kotlinlang.org/docs/coroutines-overview.html`
- Ktor: `https://ktor.io/`
- Spring Boot with Kotlin: `https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.kotlin`
- Android Developers: `https://developer.android.com/kotlin`

### Notes
- Multiple files may define their own `main` for demos. Prefer running from the IDE to choose specific examples.
- As the repo evolves, separate modules may be introduced for backend samples (Ktor/Spring) and Android sample apps.


