package vn.iotstar.bt8_28_03_25.SearchRecylerView;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import vn.iotstar.bt8_28_03_25.R;

public class IndicatorActivity extends AppCompatActivity {
    private IndicatorActivity indicatorActivity;
    private float DP;
    private List<IconModel> arraylist1;
    private IconAdapter iconAdapter;
    RecyclerView rcIcon;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_indicator);
        DP = getResources().getDisplayMetrics().density;
        SetAdapter();

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return true;
            }
        });

    }
    private void filterListener(String text){
        List<IconModel> list = new ArrayList<>();
        for(IconModel iconModel:arraylist1){
            if(iconModel.getDecs().toLowerCase().contains(text.toLowerCase())){
                list.add(iconModel);
            }
        }
        if(list.isEmpty()){
            Toast.makeText(this, "Khong co du lieu", Toast.LENGTH_SHORT).show();
        }
        else {
            iconAdapter.setListenerList(list);
        }
    }
    void SetAdapter()
    {
        rcIcon = findViewById(R.id.rcIcon);
        arraylist1 = new ArrayList<>();
        arraylist1.add(new IconModel(R.drawable.ic_1, "Mail"));
        arraylist1.add(new IconModel(R.drawable.ic_2, "Box"));
        arraylist1.add(new IconModel(R.drawable.ic_3, "Message"));
        arraylist1.add(new IconModel(R.drawable.ic_4, "Stoke"));
        arraylist1.add(new IconModel(R.drawable.ic_5, "Date"));
        arraylist1.add(new IconModel(R.drawable.ic_6, "Nofication"));
        arraylist1.add(new IconModel(R.drawable.ic_7, "Setting"));
        arraylist1.add(new IconModel(R.drawable.ic_8, "More"));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(IndicatorActivity.this, 2,
                GridLayoutManager.VERTICAL, false);
        rcIcon.setLayoutManager(gridLayoutManager);
        iconAdapter = new IconAdapter(arraylist1, getApplicationContext());
        rcIcon.setAdapter(iconAdapter);
        rcIcon.addItemDecoration(new LinePagerIndicatorDecoration());
    }

}