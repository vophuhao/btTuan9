package vn.iotstar.bt8_28_03_25.ViewPager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NotNull FragmentManager fragmentManager, @NotNull Lifecycle lifecycle){
        super(fragmentManager,lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new NewOrderFragment();
            case 1:
                return new DeliveryFragment();
            case 2:
                return new DanhGiaFragment();
            case 3:
                return new PickUpFragment();
            case 4:
                return new CancelFragment();
            default:
                return new NewOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
