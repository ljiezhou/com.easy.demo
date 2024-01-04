package com.easy.demo.main;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;

import com.easy.demo.net.bean.HttpData;
import com.easy.demo.net.bean.SearchAuthorApi;
import com.hjq.http.EasyHttp;
import com.hjq.http.listener.HttpCallbackProxy;
import com.hjq.http.listener.OnHttpListener;

import java.util.List;

/**
 * @Author ljiezhou
 * @date 2024/1/4 16:05
 * @Description
 */
public class MainViewModel extends ViewModel implements OnHttpListener<Object>, LifecycleOwner {

    private final LifecycleRegistry mLifecycle = new LifecycleRegistry(this);

    public MainViewModel() {
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mLifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycle;
    }

    public void test() {
        EasyHttp.get(this)
                .api(new SearchAuthorApi()
                        .setId(190000))
                .request(new HttpCallbackProxy<HttpData<List<SearchAuthorApi.Bean>>>(this) {

                    @Override
                    public void onHttpSuccess(HttpData<List<SearchAuthorApi.Bean>> result) {
//                        Toaster.show("Get 请求成功，请看日志");
                        Log.d(TAG, "onHttpSuccess: ");
                    }
                });
    }

    private static final String TAG = "MainViewModel";
    @Override
    public void onHttpSuccess(Object result) {

    }

    @Override
    public void onHttpFail(Throwable throwable) {

    }
}
