# Smart Life Academy 🎓

![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=android&logoColor=white)
![Flutter](https://img.shields.io/badge/Flutter-02569B?style=for-the-badge&logo=flutter&logoColor=white)
![Dart](https://img.shields.io/badge/Dart-0175C2?style=for-the-badge&logo=dart&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)

Welcome to the **Smart Life Academy** Android App! This is a modern, feature-rich educational platform built to help students track their courses, complete assignments, and manage specialized training (such as aviation flight logs).

**Architecture Note:** This project utilizes a **hybrid architecture**, combining a robust native Android core (Kotlin + Jetpack Compose) with a Flutter module (Dart) seamlessly integrated using Flutter's Add-to-App feature.

## 📱 Features

* **User Authentication:** Secure Sign Up, Login, and Logout functionality powered by Supabase Auth.
* **Student Dashboard:** A centralized hub to view active courses, pending tasks, and recent announcements.
* **Course Management:** Browse enrolled courses, view detailed curriculum, and track learning progress.
* **Lesson Viewer:** Interactive screen to read and consume lesson content.
* **Assignment Tracking:** Keep track of pending tasks and due dates.
* **Flight Logging:** A specialized module for aviation/pilot students to log and review their flight hours and training history.
* **Profile Management:** Manage user details and settings.

## 🛠 Tech Stack

Our technology stack is carefully chosen to provide high performance natively on Android, while allowing rapid UI iteration using Flutter.

### Native Android
* **Kotlin:** The primary language for the native application.
* **Jetpack Compose:** Modern, declarative UI toolkit for native Android screens (using Material Design 3).
* **Android Jetpack Libraries:** Utilizing Architecture Components like ViewModel and Lifecycle.
* **Android Navigation Compose:** For robust native screen routing.
* **Android SDK:** Core Android frameworks.

### Flutter
* **Flutter Framework:** Used via the "Add-to-App" feature to embed cross-platform screens.
* **Dart:** The programming language used for all Flutter development.

### Backend / Services
* **Supabase:** Open-source Firebase alternative providing PostgreSQL Database, Storage, and secure Authentication.
* **Ktor:** Lightweight asynchronous networking client used for Supabase operations.

### Build & Development Tools
* **Gradle:** Powerful build system managing Android dependencies, plugins, and module compilation.

## 📂 Project Structure

The workspace contains both the main native application and the embedded Flutter module.

```text
Smart Life Academy Workspace
│
├── SL academy/                     # Main Native Android Project
│   ├── app/src/main/java/          # Kotlin Source Code
│   │   ├── data/                   # Data Layer (models, repositories, remote)
│   │   ├── navigation/             # UI Navigation logic (AppNavigation)
│   │   ├── ui/                     # Jetpack Compose UI Layer (screens, theme)
│   │   └── viewmodel/              # MVVM State holders
│   └── build.gradle.kts            # Android build configuration
│
└── smart_life_flutter/             # Flutter Module
    ├── lib/
    │   └── main.dart               # Flutter/Dart entry point & source code
    └── pubspec.yaml                # Flutter dependencies & configuration
```

### 🦋 The Flutter Module (`smart_life_flutter`)
While the core application is built natively in Kotlin, the `smart_life_flutter` module is used to write select UI components and screens using Dart. This Add-to-App setup allows us to leverage Flutter's rapid, declarative UI development for specific features while maintaining the performance, architecture, and deep system integrations of a native Android app.

## 🎨 UI & Design
The native app uses a unified `SmartLifeAcademyTheme` which defines a custom color palette, typography, and shapes tailored for an engaging educational experience. It natively supports Edge-to-Edge display and Material 3 design paradigms.

---

## 🚀 Getting Started

Follow these steps to clone the repository and work with both the native Android project and the Flutter module.

### Prerequisites
* [Android Studio](https://developer.android.com/studio) (Koala or newer recommended)
* JDK 17 (or JDK 11 as configured in gradle)
* [Flutter SDK](https://docs.flutter.dev/get-started/install) (Required for the hybrid Flutter module)
* An active [Supabase](https://supabase.com/) project (for backend functionality).

### Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd <your-repo-folder>
   ```

2. **Generate / Prepare the Flutter Module:**
   The native app expects the Flutter module to exist as a sibling directory. Navigate to the parent folder of the Android app and run:
   ```bash
   flutter create -t module --org com.example smart_life_flutter
   ```
   *(Note: If the `smart_life_flutter` directory is already in your repository, simply navigate into it and run `flutter pub get` instead).*

3. **Enable the Flutter Dependency in Android:**
   * Open the Android project in Android Studio.
   * Open `app/build.gradle.kts` and ensure the line `implementation(project(":flutter"))` is uncommented.
   * Click **Sync Project with Gradle Files**.

4. **Configure Backend:**
   * Make sure your Supabase URL and API Keys are properly configured inside your `SupabaseClient.kt` or environment variables.

5. **Run the App:**
   * Select the `app` configuration in Android Studio.
   * Choose an Android Emulator or connect a physical device.
   * Click the **Run** button (Shift + F10).

## Flutter & Dart

This project uses a hybrid Android architecture combining native Kotlin with Jetpack Compose and Flutter with Dart.

- **Kotlin** - Native Android development
- **Jetpack Compose** - Native Android UI
- **Flutter** - Cross-platform UI and feature development
- **Dart** - Programming language used by Flutter
- **Flutter Module:** `smart_life_flutter`
