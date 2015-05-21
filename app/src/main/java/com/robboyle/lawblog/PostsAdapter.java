package com.robboyle.lawblog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by robboyle on 5/21/15.
 */
public class PostsAdapter extends BaseAdapter {

    private Context context;
    private List<BlogPost> posts;
    private PostSelectedListener listener;

    public PostsAdapter(Context context, List<BlogPost> posts, PostSelectedListener listener) {
        this.context = context;
        this.posts = posts;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        PostCellLayout cellLayout;
        if (view == null) {
            cellLayout = new PostCellLayout(context);
            cellLayout.setListener(listener);
        } else {
            cellLayout = (PostCellLayout) view;
        }

        cellLayout.configureViews(posts.get(i));

        return cellLayout;
    }

}
