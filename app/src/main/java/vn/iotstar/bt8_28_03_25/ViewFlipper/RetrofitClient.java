package vn.iotstar.bt8_28_03_25.ViewFlipper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("http://app.iotstar.vn/appfoods/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
