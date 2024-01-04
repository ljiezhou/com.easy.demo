package com.easy.demo.net.easy

import com.easy.demo.net.easy.server.ReleaseServer
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonToken
import com.hjq.gson.factory.GsonFactory
import com.hjq.gson.factory.ParseExceptionCallback
import com.hjq.http.EasyConfig
import com.hjq.http.config.IRequestServer
import com.easy.demo.net.BuildConfig
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


/**
 * @Author ljiezhou
 * @date 2023/12/25 17:09
 * @Description
 */

val easyHttpHolder: EasyHttpHolder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    EasyHttpHolder()
}

class EasyHttpHolder {

    fun init() {

        val timeouut = 20 * 1000L
        val build = OkHttpClient.Builder()
            .apply {
                readTimeout(timeouut, TimeUnit.MILLISECONDS)
                writeTimeout(timeouut, TimeUnit.MILLISECONDS)
                connectTimeout(timeouut, TimeUnit.MILLISECONDS)
            }

        // 设置 Json 解析容错监听
        GsonFactory.setParseExceptionCallback(object : ParseExceptionCallback {
            override fun onParseObjectException(typeToken: TypeToken<*>, fieldName: String, jsonToken: JsonToken) {
                handlerGsonParseException("解析对象析异常：$typeToken#$fieldName，后台返回的类型为：$jsonToken")
            }

            override fun onParseListItemException(typeToken: TypeToken<*>, fieldName: String, listItemJsonToken: JsonToken) {
                handlerGsonParseException("解析 List 异常：$typeToken#$fieldName，后台返回的条目类型为：$listItemJsonToken")
            }

            override fun onParseMapItemException(typeToken: TypeToken<*>, fieldName: String, mapItemKey: String, mapItemJsonToken: JsonToken) {
                handlerGsonParseException("解析 Map 异常：$typeToken#$fieldName，mapItemKey = $mapItemKey，后台返回的条目类型为：$mapItemJsonToken")
            }

            private fun handlerGsonParseException(message: String) {
                require(!BuildConfig.DEBUG) { message }
//                CrashReport.postCatchedException(IllegalArgumentException(message))
            }
        })
        // 网络请求框架初始化

        // 网络请求框架初始化
        var server: IRequestServer?
//        server = if (BuildConfig.DEBUG) {
//            TestServer()
//        } else {
//            ReleaseServer()
//        }
        server = ReleaseServer()
        EasyConfig.with(build.build()).apply {
            // 是否打印日志
            isLogEnabled = BuildConfig.DEBUG
            // 设置服务器配置
            this.server = server
            // 设置请求处理策略
            handler = RequestHandler() // 添加全局请求参数

            addParam("token", "6666666")
            // 添加全局请求头
            //.addHeader("time", "20191030")
            into()
        }
        // 设置请求重试次数
        EasyConfig.getInstance().retryCount = 3
        // 设置请求重试时间
        EasyConfig.getInstance().retryTime = 1000
    }
}