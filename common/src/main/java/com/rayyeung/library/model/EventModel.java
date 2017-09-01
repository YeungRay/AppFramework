package com.rayyeung.library.model;

/**
 * Created by RayYeung on 2016/11/16.
 */

public class EventModel {

    private int type;
    private Object content;
    private Object content1;

    public EventModel(int type) {
        this.type = type;
    }

    public EventModel(int type, Object content) {
        this.type = type;
        this.content = content;
    }

    public EventModel(int type, Object content, Object content1) {
        this.type = type;
        this.content = content;
        this.content1 = content1;
    }
}
