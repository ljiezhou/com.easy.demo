package com.easy.demo.net.easy;

import androidx.annotation.NonNull;

import com.hjq.http.config.IRequestServer;
import com.easy.demo.NetConst;

/**
 * @Author ljiezhou
 * @date 2023/12/25 16:37
 * @Description
 */
public class RequestServer implements IRequestServer {
    @NonNull
    @Override
    public String getHost() {
//        return NetConst.getUrl();
        return "";
    }
}
