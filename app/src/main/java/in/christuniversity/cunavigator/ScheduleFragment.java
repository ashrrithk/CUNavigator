package in.christuniversity.cunavigator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ScheduleFragment extends Fragment {


    public ScheduleFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewPageAdapter adapter = new ViewPageAdapter(getChildFragmentManager());
        adapter.addFragment(new DsFragment(),"Day's Schedule");
        adapter.addFragment(new MeetRequestFragment(),"Meet Request");
        ViewPager vp = getView().findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
        TabLayout tl = getView().findViewById(R.id.tabLayout);
        tl.setupWithViewPager(vp);
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    class ViewPageAdapter extends FragmentPagerAdapter{

        ArrayList<Fragment> framelist = new ArrayList<>();
        ArrayList<String> frametitle = new ArrayList<>();
        public ViewPageAdapter(@NonNull FragmentManager fm) {
            super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return frametitle.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return framelist.get(position);
        }

        @Override
        public int getCount() {
            return framelist.size();
        }

        public void addFragment(Fragment fragment,String title){
            framelist.add(fragment);
            frametitle.add(title);

        }
    }
}