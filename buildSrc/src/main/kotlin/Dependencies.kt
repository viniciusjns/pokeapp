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
        const val coroutines = "1.4.3"
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