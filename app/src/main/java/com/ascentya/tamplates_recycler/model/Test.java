package com.ascentya.tamplates_recycler.model;

// Created by Dineshkumar 10/10/2019

import android.widget.ImageView;

import com.ascentya.tamplates_recycler.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.databinding.BindingAdapter;

// Model class  for recyclerview items.
public class Test {
    // serialized name
    @SerializedName("download_url")
    private String downloadUrl;
    private String id;
    private String author;
    private Integer width;
    private Integer height;
    private String url;

    private List<Test> data;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public List<Test> getEmployee() {
        return data;
    }

    public void setEmployee(List<Test> employee) {
        this.data = employee;
    }
// binded xml and loadind image here

    @BindingAdapter({"downloadUrl"})
    public static void loadImage(ImageView imageView, String imageURL) {


        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                        .circleCrop())
                .load(imageURL)
                .placeholder(R.drawable.loading)
                .into(imageView);
    }
}
