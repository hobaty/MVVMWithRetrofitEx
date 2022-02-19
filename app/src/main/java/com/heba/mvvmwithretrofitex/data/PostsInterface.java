package com.heba.mvvmwithretrofitex.data;

import com.heba.mvvmwithretrofitex.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {
    @GET("posts")
    Call<List<PostModel>> getPosts();
}
