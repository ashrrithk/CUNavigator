package in.christuniversity.cunavigator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import in.christuniversity.cunavigator.Model.SliderItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    SliderView sliderView2;
    private SliderAdapterExample adapter2;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView DP = getView().findViewById(R.id.teacherDp);
        Glide.with(DP.getContext()).load("https://kp.christuniversity.in/KnowledgePro/images/EmployeePhotos/E3212.jpg").into(DP);
        RecyclerView programminglist = (RecyclerView) getView().findViewById(R.id.StudentList);
        programminglist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ArrayList<StudentMeet> data = new ArrayList<>();
        data.add(new StudentMeet("Yash Martin","5 BCA-A","9:00 - 9:15"));
        data.add(new StudentMeet("Yash Martin","5 BCA-A","9:15 - 9:30"));
        data.add(new StudentMeet("Yash Martin","5 BCA-A","9:30 - 9:45"));
        data.add(new StudentMeet("Yash Martin","5 BCA-A","9:45 - 10:00"));
        data.add(new StudentMeet("Yash Martin","5 BCA-A","10:00 - 10:15"));
        programminglist.setAdapter(new ProgammingAdapter(data,getContext()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}