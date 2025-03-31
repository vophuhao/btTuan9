package com.example.bttuan9.ViewFlipperCircleIndicator.api;

import com.example.bttuan9.ViewFlipperCircleIndicator.data.MessageModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ClientApi {
    @FormUrlEncoded
    @POST("newimagesmanager.php")
    Call<MessageModel> LoadImageSlider(@Field("position") int position);
}