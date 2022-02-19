package com.heba.mvvmwithretrofitex.data;

import com.heba.mvvmwithretrofitex.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostsInterface postsInterface ;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postsInterface = retrofit.create(PostsInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts (){
        return postsInterface.getPosts();
    }
}
