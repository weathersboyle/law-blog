package com.robboyle.lawblog;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends FragmentActivity implements PostSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(R.id.container, new PostsFragment()).commit();
    }

    @Override
    public void postSelected(BlogPost selectedPost) {
        Log.d("feeld", "post selected id: " + selectedPost.getId());
    }

}
