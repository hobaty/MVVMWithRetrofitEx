package com.heba.mvvmwithretrofitex.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.heba.mvvmwithretrofitex.R;
import com.heba.mvvmwithretrofitex.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    List<PostModel> postsList = new ArrayList<>();
    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {
        PostModel item = postsList.get(position);
        holder.userIdTv.setText(String.valueOf(item.getUserId()));
        holder.titleTv.setText(item.getTitle());
        holder.detailsTv.setText(item.getBody());

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    void setList(List<PostModel> postsList){
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    class PostsViewHolder  extends RecyclerView.ViewHolder{
        TextView userIdTv, titleTv, detailsTv;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.userIdTv = itemView.findViewById(R.id.userIdTv);
            this.titleTv = itemView.findViewById(R.id.titleTv);
            this.detailsTv = itemView.findViewById(R.id.detailsTv);
        }
    }
}
