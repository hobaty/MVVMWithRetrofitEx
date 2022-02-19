package com.heba.mvvmwithretrofitex.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.google.android.material.internal.ViewUtils;
import com.heba.mvvmwithretrofitex.R;
import com.heba.mvvmwithretrofitex.databinding.ActivityMainBinding;
import com.heba.mvvmwithretrofitex.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding ;
    PostsViewModel postsViewModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PostsAdapter postsAdapter = new PostsAdapter();
        binding.postsList.setAdapter(postsAdapter);
        postsViewModel = new ViewModelProvider(this).get(PostsViewModel.class);
        postsViewModel.getPosts();
        postsViewModel.postsMutableLiveData.observe(this ,new Observer<List<PostModel>>(){

            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setList(postModels);
            }
        });
    }
}