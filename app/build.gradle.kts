plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.fadhlalhafizh.pathway"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fadhlalhafizh.pathway"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField ("String", "BASE_URL", "\"https://api-backend-hzihrybpka-uc.a.run.app/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += ("-Xopt-in=kotlin.RequiresOptIn")
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    testOptions {
        animationsDisabled = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Image Circle
    implementation("de.hdodenhof:circleimageview:3.1.0")
    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    //ViewPager2
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    //Lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    //LoopJ
    implementation ("com.loopj.android:android-async-http:1.4.9")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.activity:activity-ktx:1.8.2")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    //FragmentKTX
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    //Mockito
    testImplementation("org.mockito:mockito-core:4.4.0")
    testImplementation("org.mockito:mockito-inline:4.4.0")
    //Espresso
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    implementation ("androidx.test.espresso:espresso-idling-resource:3.5.1")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.5.1")
    //EncryptedSharedPreferences
    implementation ("androidx.security:security-crypto:1.1.0-alpha06")
    //Preferences
    implementation ("androidx.preference:preference-ktx:1.2.1")
    //DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    //Room
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    //Scheduler
    implementation("androidx.work:work-runtime:2.9.0")
    //MediaExoPlayer
    implementation("androidx.media3:media3-exoplayer:1.2.0")
    implementation("androidx.media3:media3-ui:1.2.0")
    implementation("androidx.media3:media3-session:1.2.0")
    //CameraX
    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")
    //ServiceLocation
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    //special testing
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    //special instrumentation testing
    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    //TestCoroutineDispatcher
    debugImplementation("androidx.fragment:fragment-testing:1.6.2")
    //mock web server
    androidTestImplementation ("com.squareup.okhttp3:mockwebserver:4.9.3")
    androidTestImplementation ("com.squareup.okhttp3:okhttp-tls:4.9.3")
    //Paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    //PagingRoom
    implementation("androidx.room:room-paging:2.6.1")
    //Firebase
    implementation("com.google.firebase:firebase-auth-ktx:22.3.0")
    implementation("com.google.android.gms:play-services-auth:20.7.0")
    implementation("com.google.firebase:firebase-database-ktx:20.3.0")
    implementation("com.firebaseui:firebase-ui-database:8.0.0")
    //RxJava
    implementation ("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("io.reactivex.rxjava2:rxkotlin:2.4.0")
    //CoroutineFlow
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    //Lottie
    implementation ("com.airbnb.android:lottie:6.0.0")
    //ButterKnife
    implementation ("com.jakewharton:butterknife:10.2.3")
    //Picasso
    implementation ("com.squareup.picasso:picasso:2.71828")
    //Calligraphy
    implementation ("uk.co.chrisjenx:calligraphy:2.3.0")
}