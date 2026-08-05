<p align="center">
  <h1 align="center">Kross</h1>
  <p align="center">Minimalist Kotlin Multiplatform clipboard management for Android and iOS.</p>
  <p align="center">
    <a href="LICENSE"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License"></a>
    <a href="https://central.sonatype.com/"><img src="https://img.shields.io/maven-central/v/io.github.amanbutnot/kross.svg" alt="Maven Central"></a>
    <img src="https://img.shields.io/badge/Platform-Android%20%7C%20iOS-lightgrey.svg" alt="Platforms">
  </p>
</p>

---

Kross provides a type-safe, unified API to interact with system clipboards across different platforms. It abstracts away platform-specific implementations like `ClipboardManager` on Android and `UIPasteboard` on iOS.

## Features

- **Unified Interface**: Single API for copying and retrieving data.
- **Content Types**: Native support for Plain Text, HTML, and URLs.
- **Type Safety**: Leverages Kotlin sealed classes for robust data handling.
- **Lightweight**: Zero third-party dependencies.

## Installation

Add Kross to your `commonMain` dependencies in your `build.gradle.kts`:

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation("io.github.amanbutnot:kross:1.0.0")
        }
    }
}
```

## Usage

### 1. Initialization

On Android, the `Klipboard` instance requires a `Context`. On iOS, it is initialized without arguments.

```kotlin
// Android implementation
val klipboard = Klipboard(context)

// iOS implementation
val klipboard = Klipboard()
```

### 2. Copying Content

Use `saveData` with a specific `KlipData` type.

```kotlin
klipboard.saveData(KlipData.TEXT("Hello Kross"))
klipboard.saveData(KlipData.HTML("<b>Rich Text</b>"))
klipboard.saveData(KlipData.URL("https://github.com/amanbutnot/kross"))
```

### 3. Retrieving Content

Query the clipboard by passing the desired `KlipType`.

```kotlin
val text = klipboard.getData(KlipType.TEXT) as? KlipData.TEXT
val html = klipboard.getData(KlipType.HTML) as? KlipData.HTML
```

## Platform Support

| Platform | Minimum Version | Implementation |
| :--- | :--- | :--- |
| **Android** | API 24 (Nougat) | `ClipboardManager` |
| **iOS** | iOS 13.0 | `UIPasteboard` |

## License

Kross is available under the Apache License 2.0. See the [LICENSE](LICENSE) file for more info.
