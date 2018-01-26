package com.example.tablayoutviewpager;

import java.io.Serializable;

/**
 * Created by LewJun on 2018/01/26.
 */
public class Children implements Serializable {
    public int id;

    public String name;

    public Children() {
    }

    public Children(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }
}
