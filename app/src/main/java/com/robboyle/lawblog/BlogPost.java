package com.robboyle.lawblog;

/**
 * Created by robboyle on 5/21/15.
 */
public class BlogPost {

    private String title;
    private String body;

    public BlogPost(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
