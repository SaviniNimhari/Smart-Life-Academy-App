# Smart Life Academy 🎓

Welcome to the **Smart Life Academy** Android App! This is a modern, feature-rich educational platform built to help students track their courses, complete assignments, and manage specialized training (such as aviation flight logs).

## 📱 Features

* **User Authentication:** Secure Sign Up, Login, and Logout functionality powered by Supabase Auth.
* **Student Dashboard:** A centralized hub to view active courses, pending tasks, and recent announcements.
* **Course Management:** Browse enrolled courses, view detailed curriculum, and track learning progress.
* **Lesson Viewer:** Interactive screen to read and consume lesson content.
* **Assignment Tracking:** Keep track of pending tasks and due dates.
* **Flight Logging:** A specialized module for aviation/pilot students to log and review their flight hours and training history.
* **Profile Management:** Manage user details and settings.

## 🛠 Tech Stack & Architecture

This project is built using modern Android development practices and libraries:

* **Language:** 100% [Kotlin](https://kotlinlang.org/)
* **UI Toolkit:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material Design 3
* **Architecture:** MVVM (Model-View-ViewModel) with a Repository pattern
* **Backend / Database:** [Supabase](https://supabase.com/) (Auth, PostgreSQL Database, and Storage)
* **Networking:** [Ktor](https://ktor.io/) (for Supabase client operations)
* **Navigation:** Jetpack Navigation for Compose

## 📂 Project Structure

The codebase is organized cleanly by feature and layer:

```text
com.example.smartlifeacademy
│
├── data/                  # Data Layer
│   ├── model/             # Data classes (User, Course, Lesson, FlightLog)
│   ├── remote/            # Backend clients (SupabaseClient)
│   └── repository/        # Repositories (AuthRepository, CourseRepository, etc.)
│
├── navigation/            # UI Navigation logic (AppNavigation)
│
├── ui/                    # UI Layer (Jetpack Compose)
│   ├── screens/           # Compose screens (Dashboard, Login, CourseDetail, etc.)
│   └── theme/             # Design System (Color, Typography, Theme)
│
└── viewmodel/             # State holders (AuthViewModel, CourseViewModel, etc.)
```

## 🚀 Getting Started

### Prerequisites
* [Android Studio](https://developer.android.com/studio) (Koala or newer recommended)
* JDK 17 (or JDK 11 as configured in gradle)
* An active [Supabase](https://supabase.com/) project (for backend functionality).

### Setup Instructions

1. **Clone the project** and open it in Android Studio.
2. **Sync the project** with Gradle files.
3. **Configure Backend:**
   * Make sure your Supabase URL and API Keys are properly configured inside your `SupabaseClient.kt` or environment variables.
4. **Run the App:**
   * Select the `app` configuration.
   * Choose an Android Emulator or connect a physical device.
   * Click the **Run** button (Shift + F10).

## 🎨 UI & Design

The app uses a unified `SmartLifeAcademyTheme` which defines a custom color palette, typography, and shapes tailored for an engaging educational experience. It natively supports Edge-to-Edge display and Material 3 design paradigms.
