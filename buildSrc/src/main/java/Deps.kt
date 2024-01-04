object Versions {
    const val kotlin_gradle_plugin = "1.8.10"
    val junit = "4.12"

    val retrofitSdkVersion = "2.9.0"
    val lifecycleVersion = "2.5.1"
    val lifecycleExtensionsVersion = "2.2.0"

    //    val roomVersion = "2.3.0"
    val roomVersion = "2.4.2"
}

object KotlinLibs {
    //    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_gradle_plugin}"
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_gradle_plugin}"

    val coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3"
    val coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"

    val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:1.5.10"
    val coroutines = linkedSetOf(coroutines_core, coroutines_android)
}

object AndroidLibs {
    //------------------------------------------------官方库-----------------------------------------------------------
    val appcompat = "androidx.appcompat:appcompat:1.6.1"
    val appcompat_resources = "androidx.appcompat:appcompat-resources:1.6.1"
    val multidex = "androidx.multidex:multidex:2.0.1"
    val core_ktx = "androidx.core:core-ktx:1.10.1"

    //    val material = "com.google.android.material:material:1.5.0"
    val material = "com.google.android.material:material:1.11.0"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"

    val annotation = "androidx.annotation:annotation:1.7.0"
}


object LifecycleLibs {
    //lifecycle
    val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionsVersion}"
    val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycleVersion}" // lifecycleScope
    val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" // viewModelScope
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    val values = linkedSetOf(lifecycle_extensions, lifecycle_runtime, lifecycle_viewmodel_ktx, lifecycle_runtime_ktx)
}

object NetLibs {
    //network
    val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofitSdkVersion}"
    val retrofit2_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitSdkVersion}"
    val retrofit2_adapter_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitSdkVersion}"
    val okhttp3 = "com.squareup.okhttp3:okhttp:4.12.0"
    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:4.12.0"

    val rxjava3_rxjava = "io.reactivex.rxjava3:rxjava:3.1.0"
    val rxjava3_rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.0"

    val gson = "com.google.code.gson:gson:2.10.1"
    val logger = "com.orhanobut:logger:2.2.0"
    val filedownloader = "com.liulishuo.filedownloader:library:1.7.7"

    val values = linkedSetOf(
        retrofit2, retrofit2_converter_gson, retrofit2_adapter_rxjava3, okhttp3, logging_interceptor,
//        rxjava3_rxjava, rxjava3_rxandroid,
        gson, logger, filedownloader
    )
}

object CommonLibs {
    //----------------------------------------------------------------------------------------------
    val oaid = "oaid_sdk_1.0.25"

    val viewbinding_base_release = "viewbinding-base-1.0.0"
    val circleImageView = "circleimageview-2.2.0"

    val BaseRecyclerViewAdapterHelper4 = "io.github.cymchad:BaseRecyclerViewAdapterHelper4:4.1.2"

    val mmkv = "com.tencent:mmkv-static:1.3.0"
    val mmkv_ktx = "com.github.DylanCaiCoding:MMKV-KTX:1.2.16"

    val xpopup = "com.github.li-xiaojun:XPopup:2.9.19"
    val utilcodex = "com.blankj:utilcodex:1.31.1"

    val junkcode = "com.github.qq549631030:android-junk-code:1.3.2"
}

object DataStore {
    val datastore = "androidx.datastore:datastore-preferences:1.0.0"
    val datastore_rxjava2 = "androidx.datastore:datastore-preferences-core:1.0.0"
    val values = linkedSetOf(datastore, datastore_rxjava2)
}

object Immersionbar {
    // 基础依赖包，必须要依赖
    val immersionbar = "com.geyifeng.immersionbar:immersionbar:3.2.2"

    // kotlin扩展（可选）
    val immersionbar_ktx = "com.geyifeng.immersionbar:immersionbar-ktx:3.2.2"

    // fragment快速实现（可选）已废弃
    val immersionbar_components = "com.geyifeng.immersionbar:immersionbar-components:3.2.2"
    val values = linkedSetOf(immersionbar, immersionbar_ktx)
}

object Easy {
    val easy_http = "EasyHttp-12.8"
    val easy_http_ = "com.github.getActivity:EasyHttp:12.6"
    val easyWindow = "com.github.getActivity:EasyWindow:10.6"
    val easy_http_factory = "com.github.getActivity:GsonFactory:9.3"
}

object StringFog {
    val stringfog = "com.github.megatronking.stringfog:gradle-plugin:5.1.0"
    val stringfog_xor = "com.github.megatronking.stringfog:xor:5.0.0"
}
