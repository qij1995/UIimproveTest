package com.example.administrator.uiimprovetest;

/**
 * Created by qijiajun on 2016/8/16.
 */
public class Item {
    private String text;
    private String text1;
    private String text2;
    private int imageId;
    private int[] resource;

    public Item(String text,String text1,String text2, int imageId, int[] resource) {
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
        this.imageId = imageId;
        this.resource = resource;
    }

    public String getText() {
        return text;
    }
    public String getText1() {
        return text1;
    }
    public String getText2() {
        return text2;
    }
    public int getImageId() {
        return imageId;
    }

    public int[] getResource() {
        return resource;
    }

}
