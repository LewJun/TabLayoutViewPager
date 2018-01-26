package com.example.tablayoutviewpager;

public class PreventFastClickUtils {
    private static long lastClickTime;
    private final static long TIME = 800;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < TIME) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
