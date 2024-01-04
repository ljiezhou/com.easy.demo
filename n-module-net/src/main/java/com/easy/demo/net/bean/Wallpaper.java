package com.easy.demo.net.bean;

import java.io.Serializable;

/**
 * @Author ljiezhou
 * @date 2022/4/20 14:24
 * @Description 模版
 */
public class Wallpaper implements Serializable {
    public int fantashrs_id;

    //缩略图
    public String fantashrs_iconimg;


    //静态壁纸 图片下载地址
    public String fantashrs_wmurl;

    //静态壁纸 详情页展示链接  动态壁纸 详情页展示链接
    public String fantashrs_wmcenurl;

    //动态壁纸 视频下载地址
    public String fantashrs_wmp4;

    //动态壁纸 视频展示地址
    public String fantashrs_wmp4abbr;

    public String getFantashrs_wmurl() {
        return getUrl(fantashrs_wmurl);
    }

    public String getWmp4abbr() {
        return getUrl(fantashrs_wmp4abbr);
    }

    public int fantashrs_wmtype;

    private String getUrl(String url) {
        try {
            if (url.contains("?"))
                return url.substring(0, url.lastIndexOf("?"));
            else return url;
        } catch (Exception e) {
            e.printStackTrace();
            return url;
        }
    }
}
