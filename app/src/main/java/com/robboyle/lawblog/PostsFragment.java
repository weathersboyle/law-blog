package com.robboyle.lawblog;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    private ListView postsListView;

    private List<BlogPost> posts;
    private PostsAdapter adapter;
    private PostSelectedListener listener;

    public PostsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        posts = new ArrayList<>();
        adapter = new PostsAdapter(getActivity(), posts, listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blogs, container, false);

        postsListView = (ListView) rootView.findViewById(R.id.posts_list_view);
        postsListView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        listener = (PostSelectedListener) activity;
    }

    @Override
    public void onResume() {
        super.onResume();

        fetchPosts();
    }

    private void fetchPosts() {
        LearnServiceManager.getLearnService().getPosts(new Callback<List<BlogPost>>() {
            @Override
            public void success(List<BlogPost> blogPosts, Response response) {
                posts.clear();
                posts.addAll(blogPosts);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
