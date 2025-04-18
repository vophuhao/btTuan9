package vn.iotstar.bt8_28_03_25;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import vn.iotstar.bt8_28_03_25.SearchRecylerView.IndicatorActivity;
import vn.iotstar.bt8_28_03_25.ViewFlipper.SildeImageActivity;
import vn.iotstar.bt8_28_03_25.ViewFlipper.SlideImageWithCirleIndicatorActivity;
import vn.iotstar.bt8_28_03_25.ViewFlipper.SliderView.SliderViewActiivity;
import vn.iotstar.bt8_28_03_25.ViewFlipper.ViewPager2vsIndicator3.ViewPager2_Indicator3Activity;
import vn.iotstar.bt8_28_03_25.ViewPager2.ViewPager_tablayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn_viewPager = findViewById(R.id.btn_viewpager);
        btn_viewPager.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewPager_tablayout.class);
            startActivity(intent);
        });
        Button btn_indicator = findViewById(R.id.btn_indicator);
        btn_indicator.setOnClickListener(view -> {
            Intent intent= new Intent(MainActivity.this, IndicatorActivity.class);
            startActivity(intent);
        });
        Button btn_viewFliper1 = findViewById(R.id.btn_viewFlipper1);
        btn_viewFliper1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SildeImageActivity.class);
            startActivity(intent);
        });
        Button btn_v2 = findViewById(R.id.btn_v2);
        btn_v2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SlideImageWithCirleIndicatorActivity.class);
            startActivity(intent);
        });
        Button btn_viewpager2 = findViewById(R.id.btn_viewPage2);
        btn_viewpager2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ViewPager2_Indicator3Activity.class);
            startActivity(intent);
        });
        Button btn_slider = findViewById(R.id.btn_sliderview);
        btn_slider.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, SliderViewActiivity.class);
            startActivity(intent);
        });
    }
}