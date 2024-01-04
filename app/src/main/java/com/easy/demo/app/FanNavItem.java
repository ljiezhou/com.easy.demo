package com.easy.demo.app;

import androidx.fragment.app.Fragment;

/**
 * @Author ljiezhou
 * @date 2023/11/1 14:53
 * @Description
 */
public class FanNavItem {
    public int id;
    public Fragment fragment;
    public int title;
    public int icon;

    public FanNavItem(int id, Fragment fragment, int title, int icon) {
        this.id = id;
        this.fragment = fragment;
        this.title = title;
        this.icon = icon;
    }


}
