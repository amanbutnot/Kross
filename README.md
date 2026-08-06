<p align="center">
  <h1 align="center">Kross</h1>
  <p align="center">A comprehensive Kotlin Multiplatform library for Android and iOS.</p>
  <p align="center">
    <a href="LICENSE"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg" alt="License"></a>
    <a href="https://central.sonatype.com/"><img src="https://img.shields.io/maven-central/v/io.github.amanbutnot/kross.svg" alt="Maven Central"></a>
    <img src="https://img.shields.io/badge/Platform-Android%20%7C%20iOS-lightgrey.svg" alt="Platforms">
  </p>
</p>

---

Kross is an "all-in-one" Kotlin Multiplatform library designed to simplify cross-platform development. It provides a suite of unified, type-safe APIs for common platform tasks, starting with robust clipboard management.

## Installation

Add Maven Central to your repositories:

```kotlin
repositories {
    mavenCentral()
}
```

### Option 1: Full Library (Recommended)
Access all Kross features (Clipboard, etc.) through a single dependency.

```kotlin
// In commonMain
implementation("io.github.amanbutnot:kross:<latest>")
```

### Option 2: Specific Modules
If you only need a specific feature, you can include individual modules.

#### Clipboard
```kotlin
// In commonMain
implementation("io.github.amanbutnot:kross-clipboard:<latest>")
```

## Features

### Clipboard Management
Kross Clipboard provides a type-safe, unified API to interact with system clipboards. It abstracts away platform-specific implementations like `ClipboardManager` on Android and `UIPasteboard` on iOS.

- **Unified Interface**: Single API for copying and retrieving data.
- **Content Types**: Native support for Plain Text, HTML, and URLs.
- **Type Safety**: Leverages Kotlin sealed classes for robust data handling.
- **Lightweight**: Zero third-party dependencies.

## Usage (Clipboard)

### 1. Initialization
`Klipboard` is initialized without arguments on all platforms.

```kotlin
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

| Platform    | Minimum Version | Implementation     |
|:------------|:----------------|:-------------------|
| **Android** | API 24 (Nougat) | `ClipboardManager` |
| **iOS**     | iOS 13.0        | `UIPasteboard`     |

## License

Kross is available under the Apache License 2.0. See the [LICENSE](LICENSE) file for more info.
