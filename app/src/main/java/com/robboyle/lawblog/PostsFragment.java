package com.robboyle.lawblog;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    private ListView postsListView;

    private List<BlogPost> posts;
    private PostsAdapter adapter;

    public PostsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        posts = new ArrayList<>();
        addDummyPosts();

        adapter = new PostsAdapter(getActivity(), posts);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_blogs, container, false);

        postsListView = (ListView) rootView.findViewById(R.id.posts_list_view);
        postsListView.setAdapter(adapter);

        return rootView;
    }

    private void addDummyPosts() {
        String title, body;
        for (int i = 0; i < 10; i++) {
            title = "Title " + i;
            body = "Body" + i;
            posts.add(new BlogPost(title, body));
        }
    }

}
