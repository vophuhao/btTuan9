package com.example.bttuan9.FragmentViewPaper2TabLayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bttuan9.R;
import com.example.bttuan9.databinding.ActivityFragmentViewPaper2TabLayoutBinding;
import com.example.bttuan9.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class Fragment_ViewPaper2_TabLayout extends AppCompatActivity {

    private ActivityFragmentViewPaper2TabLayoutBinding binding;
    private ViewPaper2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentViewPaper2TabLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ViewPaper2Adapter(this);
        binding.viewPager2.setAdapter(adapter); // Gán adapter để ViewPager2 hiển thị danh sách Fragment khi lướt

        //Tạo tab và lướt viewPaper2 thì tab cũng luot theo _ Liên kết tab với viewpaper2
        new TabLayoutMediator(binding.tabLayout, binding.viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Đơn mới");
                    break;
                case 1:
                    tab.setText("Đang xử lý");
                    break;
                case 2:
                    tab.setText("Hoàn thành");
                    break;
            }
        }).attach();
    }
}