package vn.iotstar.bt8_28_03_25.ViewFlipper;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.bt8_28_03_25.R;

public class SildeImageActivity extends AppCompatActivity {

    ViewFlipper viewFlipperMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_silde_image);
        viewFlipperMain = findViewById(R.id.viewFlipperMain);
        ActionViewFlipperMain();

    }
    private void ActionViewFlipperMain()
    {
        List<String> arraylistFliperr = new ArrayList<>();
        arraylistFliperr.add("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png");
        arraylistFliperr.add("http://app.iotstar.vn:8081/appfoods/flipper/coffee.jpg");
        arraylistFliperr.add("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg");
        arraylistFliperr.add("http://app.iotstar.vn:8081/appfoods/flipper/themoingon.jpeg");
        for(int i = 0; i<arraylistFliperr.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(arraylistFliperr.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipperMain.addView(imageView);
        }
        viewFlipperMain.setFlipInterval(3000);
        viewFlipperMain.setAutoStart(true);
        //Thiet lap animation cho viiewFliper
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipperMain.setInAnimation(slide_in);
        viewFlipperMain.setOutAnimation(slide_out);
    }
}