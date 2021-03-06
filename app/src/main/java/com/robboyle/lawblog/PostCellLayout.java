package com.robboyle.lawblog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by robboyle on 5/21/15.
 */
public class PostCellLayout extends LinearLayout {

    private ImageView iconView;
    private TextView titleTextView;

    private BlogPost post;
    private PostSelectedListener listener;

    public PostCellLayout(Context context) {
        super(context);
        init();
    }

    public PostCellLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PostCellLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PostCellLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        setOrientation(HORIZONTAL);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(
                R.dimen.post_cell_height)));
        setBackgroundResource(R.drawable.list_item_bg);

        LayoutInflater.from(getContext()).inflate(R.layout.post_cell, this, true);
        iconView = (ImageView) findViewById(R.id.icon);
        titleTextView = (TextView) findViewById(R.id.title);

        listener = new PostSelectedListener() {
            @Override
            public void postSelected(BlogPost selectedPost) {

            }
        };

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.postSelected(post);
            }
        });
    }

    public void configureViews(BlogPost post) {
        this.post = post;

        iconView.setImageResource(R.drawable.btn_good);
        titleTextView.setText(post.getTitle());
    }

    public void setListener(PostSelectedListener listener) {
        this.listener = listener;
    }
    
}
