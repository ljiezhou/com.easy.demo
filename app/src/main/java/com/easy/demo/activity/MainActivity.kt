package com.easy.demo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.easy.demo.databinding.FanMainActivityBinding
import com.easy.demo.main.FanMainViewModel
import com.easy.demo.main.MainViewModel
import com.easy.demo.net.bean.HttpData
import com.easy.demo.net.bean.SearchAuthorApi
import com.hjq.http.EasyHttp
import com.hjq.http.listener.HttpCallbackProxy
import com.hjq.http.listener.OnHttpListener

class MainActivity : AppCompatActivity(), OnHttpListener<HttpData<List<SearchAuthorApi.Bean?>?>> {
    private lateinit var binding: FanMainActivityBinding
    private val mainViewModel: FanMainViewModel by lazy {
        ViewModelProvider(this)[FanMainViewModel::class.java]
    }
    private val mainViewModel2: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FanMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getKotlin.setOnClickListener {
            mainViewModel.test()
        }
        binding.getJava.setOnClickListener {
            mainViewModel2.test()
        }
        binding.getMain.setOnClickListener {
            EasyHttp.get(this)
                .api(
                    SearchAuthorApi()
                        .setId(190000)
                )
                .request(object : HttpCallbackProxy<HttpData<List<SearchAuthorApi.Bean>>>(this) {
                    override fun onHttpSuccess(result: HttpData<List<SearchAuthorApi.Bean>>) {
                        Log.d(FanMainViewModel.TAG, "onHttpSuccess: ")
                    }
                })

        }
    }

    override fun onHttpSuccess(result: HttpData<List<SearchAuthorApi.Bean?>?>?) {

    }

    override fun onHttpFail(throwable: Throwable?) {
    }
}
