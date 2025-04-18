package vn.iotstar.bt8_28_03_25.ViewFlipper.api;

import vn.iotstar.bt8_28_03_25.ViewFlipper.Model.MessageModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface ClientApi {
    @FormUrlEncoded
    @POST("newimagesmanager.php")
    Call<MessageModel> LoadImageSlider(@Field("position") int position);
}
