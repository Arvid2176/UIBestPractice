package com.example.uibestpractice.entity;

/**
 * 存放消息的实体类
 * Created by 安维 on 2017/4/26.
 */

public class Msg {
    private String content;
    private int type;
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SEND=1;
    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
