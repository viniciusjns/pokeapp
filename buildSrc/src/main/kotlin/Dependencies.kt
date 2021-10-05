import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(target: Project) = Unit
}

object Android {
    object Versions {
        const val core = "1.3.2"
        const val appCompat = "1.2.0"
        const val material = "1.3.0"
        const val constraint = "2.0.4"
        const val recyclerView = "1.1.0"
        const val cardview = "1.0.0"
        const val legacy = "1.0.0"
        const val lifecycle = "2.3.1"
    }

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
}

object Kotlin {
    object Versions {
        const val kotlin = "1.5.10"
    }

    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
}

object Gradle {
    object Versions {
        const val gradle = "4.1.3"
        const val kotlin = "1.5.10"
    }

    const val buildTools = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Moshi {
    object Versions {
        const val moshi = "1.12.0"
    }

    const val core = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val coreKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Coroutines {
    object Versions {
        const val coroutines = "1.5.1"
    }

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object Dagger {
    object Versions {
        const val dagger = "2.34"
    }

    const val core = "com.google.dagger:dagger:${Versions.dagger}"
    const val android = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val androidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}

object Retrofit {
    object Versions {
        const val retrofit = "2.9.0"
        const val coroutinesAdapter = "0.9.2"
    }

    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"
}

object OkHttp {
    object Versions {
        const val okhttp = "3.14.9"
    }

    const val core = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val mockWebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
}

object UnitTest {
    object Versions {
        const val junit = "4.12"
        const val ext = "1.1.2"
        const val espresso = "3.3.0"
        const val mockk = "1.12.0"
        const val core = "2.1.0"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val ext = "androidx.test.ext:junit:${Versions.ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val core = "androidx.arch.core:core-testing:${Versions.core}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}

object Glide {
    object Versions {
        const val glide = "4.12.0"
        const val palette = "2.1.2"
    }

    const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val palette = "com.github.florent37:glidepalette:${Versions.palette}"
}