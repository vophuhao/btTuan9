package vn.iotstar.bt8_28_03_25.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

import vn.iotstar.bt8_28_03_25.R;
import vn.iotstar.bt8_28_03_25.databinding.ActivityViewPagerTablayoutBinding;

public class ViewPager_tablayout extends AppCompatActivity {
    private ActivityViewPagerTablayoutBinding binding;
    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ViewBiding
        binding = ActivityViewPagerTablayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //Toolbar
        setSupportActionBar(binding.toolBar);

        FloatingActionButton fab =  binding.fabAction;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Xác nhận"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Lấy hàng"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Đang giao"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Đánh giá"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Hủy"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager2Adapter = new ViewPager2Adapter(fragmentManager, getLifecycle());
        binding.viewPager2.setAdapter(viewPager2Adapter);
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager2.setCurrentItem(tab.getPosition());
                changeFabIcon(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback(){
            @Override
            public void onPageSelected(int position){
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }
        });

    }
    private void changeFabIcon(final int index){
        binding.fabAction.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0: binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_chat_24)); break;
                    case 1:binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_camera_24));break;
                    case 2:binding.fabAction.setImageDrawable(getDrawable(R.drawable.baseline_call_24));break;
                }
                binding.fabAction.show();
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSearch) {
            Toast.makeText(this, "Bạn đang chọn search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuNewGroup) {
            Toast.makeText(this, "Bạn đang chọn New Group", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuBroadcast) {
            Toast.makeText(this, "Bạn đang chọn New Broadcast", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuWeb) {
            Toast.makeText(this, "Bạn đang chọn WhatsApp Web", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuMessage) {
            Toast.makeText(this, "Bạn đang chọn Starred Messages", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.menuSetting) {
            Toast.makeText(this, "Bạn đang chọn Settings", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}