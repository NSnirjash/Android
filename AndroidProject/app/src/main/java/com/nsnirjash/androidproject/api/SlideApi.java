package com.nsnirjash.androidproject.api;

import com.nsnirjash.androidproject.model.Slide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SlideApi {

    @GET("get_slides.php")
    Call<List<Slide>> getSlides();
}
