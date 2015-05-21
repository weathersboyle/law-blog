package com.robboyle.lawblog;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by robboyle on 5/21/15.
 */
public interface LearnService {

    @GET("/posts")
    void getPosts(
            Callback<List<BlogPost>> callback
    );

}
