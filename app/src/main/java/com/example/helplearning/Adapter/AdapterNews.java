package com.example.helplearning.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helplearning.Model.Item;
import com.example.helplearning.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterNews extends BaseAdapter {
    ArrayList<Item> items;

    public AdapterNews(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_news, viewGroup, false);
        TextView tvDate = view.findViewById(R.id.tvDate);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        ImageView imgView = view.findViewById(R.id.imgView);
        String content = items.get(i).getContent();
        String date = items.get(i).getDate();
        tvDate.setText(date.substring(0, date.indexOf("+0700")));
        tvDescription.setText(items.get(i).getDescription());
        tvTitle.setText(items.get(i).getTitle());
        String image = null;
        image = content.substring(content.indexOf("img src=") + 9, content.indexOf("alt=\"{") - 2);
        Picasso.get().load(image).into(imgView);
        return view;
    }
}
