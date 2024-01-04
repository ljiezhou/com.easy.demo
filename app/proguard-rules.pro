# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


#-keep class com.module.net.** {*;}

#-keep public interface androidx.viewbinding.ViewBinding
#-keep class * implements androidx.viewbinding.ViewBinding{
#    *;
#}

##############################去掉所有打印 包括自己封装的
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** e(...);
    public static *** i(...);
    public static *** v(...);
    public static *** println(...);
    public static *** w(...);
    public static *** wtf(...);
}
-assumenosideeffects class android.util.Log {
   public static *** d(...);
   public static *** v(...);
}

-assumenosideeffects class android.util.Log {
    public static *** e(...);
    public static *** v(...);
}

-assumenosideeffects class android.util.Log {
    public static *** i(...);
    public static *** v(...);
}

-assumenosideeffects class android.util.Log {
    public static *** w(...);
    public static *** v(...);
}
-assumenosideeffects class java.io.PrintStream {
    public *** println(...);
    public *** print(...);
}

-assumenosideeffects class com.parent.common.util.LogUtils{
    public static *** d(...);
    public static *** dTag(...);

    public static *** e(...);
    public static *** eTag(...);

    public static *** i(...);
    public static *** iTag(...);

    public static *** w(...);
    public static *** wTag(...);
}

-keep class cn.oasis.plugin.ui.** {*;}

#####方法名等混淆指定配置
-obfuscationdictionary proguard_keywords.txt
#####类名混淆指定配置
-classobfuscationdictionary proguard_keywords.txt
#####包名混淆指定配置
-packageobfuscationdictionary proguard_keywords.txt


-keep class com.hjq.window.** {*;}


-keep class com.shuyu.gsyvideoplayer.video.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.**
-keep class com.shuyu.gsyvideoplayer.video.base.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.video.base.**
-keep class com.shuyu.gsyvideoplayer.utils.** { *; }
-dontwarn com.shuyu.gsyvideoplayer.utils.**
-keep class com.shuyu.gsyvideoplayer.player.** {*;}
-dontwarn com.shuyu.gsyvideoplayer.player.**
-keep class tv.danmaku.ijk.** { *; }
-dontwarn tv.danmaku.ijk.**
-keep class androidx.media3.** {*;}
-keep interface androidx.media3.**

-keep class com.shuyu.alipay.** {*;}
-keep interface com.shuyu.alipay.**

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, java.lang.Boolean);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keep class com.fan.wallpaper.fantasy.home.viewmodel.FanGetListViewModel {*;}


-keep class com.fan.wallpaper.fantasy.net.bean.** {*;}
-keep class com.fan.wallpaper.fantasy.net.easy.** {*;}
#-keep class com.fan.wallpaper.fantasy.net.bean.HttpData {*;}


# OkHttp3
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**

# 不混淆这个包下的类
-keep class com.hjq.http.** {
    <fields>;
}