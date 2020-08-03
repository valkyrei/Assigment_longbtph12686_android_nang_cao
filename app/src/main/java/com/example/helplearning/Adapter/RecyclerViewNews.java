package com.example.helplearning.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helplearning.Model.Course;
import com.example.helplearning.Model.Item;
import com.example.helplearning.R;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewNews extends RecyclerView.Adapter<RecyclerViewNews.ViewHolder> {
    ArrayList<Item> items;
    public OnClickItem onClickItem;

    public RecyclerViewNews(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        String content = items.get(i).getContent();
        String date = items.get(i).getDate();
        holder.tvDate.setText(date.substring(0, date.indexOf("+0700")));
        holder.tvDescription.setText(items.get(i).getDescription());
        holder.tvTitle.setText(items.get(i).getTitle());
        String image = null;
        image = content.substring(content.indexOf("img src=") + 9, content.indexOf("alt=\"{") - 2);
        Picasso.get().load(image).into(holder.imageView);
        ShareLinkContent contentShare = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse(items.get(i).getLink()))
                .build();
        holder.shareButton.setShareContent(contentShare);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItem.callBackClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvDate, tvDescription, tvTitle;
        public View view;
        public ShareButton shareButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            imageView = itemView.findViewById(R.id.imgView);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            shareButton = itemView.findViewById(R.id.btnShare);

        }
    }

    public void onClick(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface OnClickItem {
        void callBackClick(int position);
    }

}
