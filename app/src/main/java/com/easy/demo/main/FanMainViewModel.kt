package com.easy.demo.main

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easy.demo.app.FanNavItem
import com.easy.demo.net.bean.HttpData
import com.easy.demo.net.bean.SearchAuthorApi
import com.hjq.http.EasyHttp
import com.hjq.http.listener.HttpCallbackProxy
import com.hjq.http.listener.OnHttpListener

/**
 * @Author ljiezhou
 * @date 2023/7/17 13:46
 * @Description
 */
class FanMainViewModel : ViewModel(), OnHttpListener<Any>, LifecycleOwner {

    private val mLifecycle = LifecycleRegistry(this)

    init {
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onCleared() {
        super.onCleared()
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    override val lifecycle: Lifecycle
        get() = mLifecycle


    fun test() {
        EasyHttp.get(this)
            .api(
                SearchAuthorApi().setId(190000)
            )
            .request(object : HttpCallbackProxy<HttpData<List<SearchAuthorApi.Bean>>>(this) {
                override fun onHttpSuccess(result: HttpData<List<SearchAuthorApi.Bean>>) {
//                    Toaster.show("Get 请求成功，请看日志")
                    Log.d(TAG, "onHttpSuccess: ")
                }
            })
    }
    

    override fun onHttpSuccess(result: Any?) {

    }

    override fun onHttpFail(throwable: Throwable?) {
        Log.d(TAG, "onHttpFail: ")
    }

    companion object{
        const val TAG = "FanMainViewModel"
    }
}