package com.easy.demo.net.easy.api;

import androidx.annotation.NonNull;

import com.hjq.http.config.IRequestApi;

/**
 * @Author ljiezhou
 * @date 2023/12/25 17:46
 * @Description
 */
public final class GetListApi implements IRequestApi {
    @NonNull
    @Override
    public String getApi() {
        return "v2/wallpaper/getList";
    }

    private int cid;
    private int page;

    public GetListApi setCid(int cid) {
        this.cid = cid;
        return this;
    }

    public GetListApi setPage(int page) {
        this.page = page;
        return this;
    }
}
