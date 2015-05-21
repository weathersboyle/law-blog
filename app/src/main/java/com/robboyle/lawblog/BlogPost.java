package com.robboyle.lawblog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by robboyle on 5/21/15.
 */
public class BlogPost {

    private Integer id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updated_at;
    private String title;
    private String body;

    public BlogPost(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
