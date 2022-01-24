import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newapp.EntertainmentFragment;
import com.example.newapp.HealthFragment;
import com.example.newapp.ScienceFragment;
import com.example.newapp.SportsFragment;
import com.example.newapp.homeFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    int tabcount=0;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return new homeFragment();
            case 1: return new SportsFragment();
            case 2: return new ScienceFragment();
            case 3: return new HealthFragment();
            case 4: return new EntertainmentFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
