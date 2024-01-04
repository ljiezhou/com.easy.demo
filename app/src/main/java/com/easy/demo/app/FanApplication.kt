package com.easy.demo.app

import android.app.Application
import android.content.Context
import com.easy.demo.net.easy.FanAppContext
import com.easy.demo.net.easy.easyHttpHolder

class FanApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        easyHttpHolder.init()
        FanAppContext.init(this,this)
    }


}