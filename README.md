# 🪙 CryptRo - Ultimate Cryptocurrency Tracker & Portfolio

<div align="center">
  <img src="https://i.postimg.cc/DZXncnYQ/cryptro_jpg.jpg" alt="CryptRo Logo" width="1080" height="1080" style="border-radius: 40px; box-shadow: 0px 0px 20px rgba(0, 241, 94, 0.5);">
  <br><br>
  <h3><b>CryptRo</b> is a cutting-edge Android application designed to track real-time cryptocurrency prices, analyze market trends, and manage your portfolio effortlessly.</h3>
</div>

<br>

[![Watch CryptRo Demo](https://img.youtube.com/vi/25foowwZvdM/maxresdefault.jpg)](https://www.youtube.com/watch?v=25foowwZvdM)
<br>

Built with **Kotlin** and **Jetpack Compose**, it leverages the power of **CoinGecko API** following the **Clean Architecture** principles and **MVVM** pattern to ensure scalability, testability, and performance.

## ✨ Features

* **🚀 Modern UI:** Fully built with **Jetpack Compose** & **Material 3** Design.
* **📱 Adaptive Layout:** Smart responsive design that adapts seamlessly to **Tablets** (Split-screen / List-Detail view) and Phones.
* **🎨 Material You:** Supports **Dynamic Colors** (Monet), extracting the theme from the user's wallpaper for a personalized look.
* **📈 Live Market Data:** Real-time tracking for thousands of cryptocurrencies including Bitcoin, Ethereum, and more.
* **📊 Interactive Charts:** Detailed visualizations for price history (1H, 24H, 7D, 1Y) using advanced charting libraries.
* **💼 Portfolio Manager:** Track your holdings and calculate profits/losses locally using **Room Database**.
* **🔍 Smart Search:** Instantly find coins with optimized search functionality.
* **🏎️ Performance:** Heavy use of **Coroutines** & **Flow** for asynchronous operations and smooth state management.
* **🌑 Dark Mode:** optimized 'Matrix Green' aesthetic for eye comfort during night trading.

## 📸 Screenshots

| Coins  (Home) | Market Details | Tablet View (Adaptive) |
|:---------:|:-------------:|:---------:|
| <img src="https://i.postimg.cc/kGP91zk0/Screenshot_20260105_181040.png" width="200"/> | <img src="https://i.postimg.cc/6qxwjgk3/Screenshot_20260105_181057.png" width="200"/> | <img src="https://i.postimg.cc/mgWSVwp4/Tablet.png" width="300"/> |

## 🛠️ Tech Stack & Libraries

* **Language:** [Kotlin](https://kotlinlang.org/) (100%)
* **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
* **Architecture:** Clean Architecture (Data, Domain, Presentation) + MVVM.
* **Dependency Injection:** [Koin](https://insert-koin.io/) - A pragmatic lightweight dependency injection framework for Kotlin.
* **Network:** [Retrofit](https://square.github.io/retrofit/) + [OkHttp](https://square.github.io/okhttp/).
* **Serialization:** [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization).
* **Local Database:** [Room](https://developer.android.com/training/data-storage/room).
* **Image Loading:** [Coil](https://coil-kt.github.io/coil/).
* **Charting:** [Vico](https://github.com/patrykandpatrick/vico) or [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart).
* **Async:** Coroutines & StateFlow.
* **Navigation:** Navigation Compose (Adaptive Strategies).
* **Window Manager:** [Jetpack WindowManager](https://developer.android.com/jetpack/androidx/releases/window) for foldable/tablet support.

## 🏗️ Architecture Overview

The app follows the **Clean Architecture** guidelines:

1.  **Domain Layer:** Contains UseCases, Domain Models, and Repository Interfaces. It is pure Kotlin and has no Android dependencies.
2.  **Data Layer:** Contains API implementation (Retrofit), Database (Room), DTOs, and Repository Implementations. Maps data to Domain models.
3.  **Presentation Layer:** Contains UI (Compose Screens) and ViewModels.

### Package Structure
```text
com.robert.cryptro
├── core          # Core components (Base Classes, Constants, Utils)
├── di            # Koin Modules (AppModule, NetworkModule, RepositoryModule)
├── crypto        # Feature Module (Coins & Market)
│   ├── data      # API, DTOs, Mappers, Repository Impl 
│   ├── domain    # Models, Repository Interfaces, UseCases 
│   └── presentation # UI Screens, ViewModels, Components
└── ui            # App Entry Point, Navigation, Theme
