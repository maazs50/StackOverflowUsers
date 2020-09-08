package com.example.paginglib.network;

import com.example.paginglib.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("2.2/answers")
    Call<StackApiResponse> getAnswers(@Query("page") int page,@Query("pagesize") int pageSize, @Query("site") String site);
}
