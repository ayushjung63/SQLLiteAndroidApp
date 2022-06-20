package com.ayush.dietandhealth.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ayush.dietandhealth.R;

import com.ayush.dietandhealth.model.Post;

import java.util.List;

public class SimpleArrayAdapter extends ArrayAdapter<Post> {
    private final int resourceLayout;
    private final Context mContext;

    public SimpleArrayAdapter(@NonNull Context context, int resource, @NonNull List<Post> items) {
        super(context, resource, items);
        this.mContext = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);
        }

        Post item = getItem(position);

        if (item != null) {
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView subTitle = (TextView) v.findViewById(R.id.sub_title);

            if (title != null) {
                title.setText(item.getTitle());
            }

            if (subTitle != null) {
                subTitle.setText(item.getDescription());
            }
        }
        return v;
    }

    @Nullable
    @Override
    public Post getItem(int position) {
        return super.getItem(position);
    }
}
