package com.example.bttuan9;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bttuan9.FragmentViewPaper2TabLayout.Fragment_ViewPaper2_TabLayout;
import com.example.bttuan9.RecyclerViewWithIndicator.RecyclerViewWithIndicator;
import com.example.bttuan9.ViewFlipperCircleIndicator.ViewFlipperCircleIndicator2;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn1=findViewById(R.id.RecyclerViewWithIndicator);
        btn1.setOnClickListener(v->open1());
        btn2=findViewById(R.id.Fragment_ViewPaper2_TabLayout);
        btn2.setOnClickListener(v->open2());
        btn3=findViewById(R.id.ViewFlipper_CircleIndicator);
        btn3.setOnClickListener(v->open3());
    }

    private void open1() {
        Intent intent = new Intent(this, RecyclerViewWithIndicator.class);
        startActivity(intent);
    }
    private void open2() {
        Intent intent = new Intent(this, Fragment_ViewPaper2_TabLayout.class);
        startActivity(intent);
    }
    private void open3() {
        Intent intent = new Intent(this, ViewFlipperCircleIndicator2.class);
        startActivity(intent);
    }

}