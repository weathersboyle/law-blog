package com.robboyle.lawblog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by robboyle on 5/21/15.
 */
public class LearnServiceManager {

    public static final String LEARN_ENDPOINT = "http://intpdlearnrails.herokuapp.com";

    private static final Gson GSON = new GsonBuilder().create();

    private static RestAdapter serviceAdapter;
    private static LearnService learnService;

    static {
        serviceAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(LEARN_ENDPOINT)
                .setConverter(new GsonConverter(GSON))
                .build();
    }

    public static LearnService getLearnService() {
        if (learnService == null) {
            learnService = serviceAdapter.create(LearnService.class);
        }
        return learnService;
    }

}
