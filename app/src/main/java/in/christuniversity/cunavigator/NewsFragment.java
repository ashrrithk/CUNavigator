package in.christuniversity.cunavigator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import in.christuniversity.cunavigator.Model.SliderItem;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    SliderView sliderView2;
    private SliderAdapterExample adapter2;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inflate the layout for this fragment
        sliderView2 = getView().findViewById(R.id.imageSlider2);
        sliderView2.setSliderAdapter(new SliderAdapterExample(getContext()));

        adapter2 = new SliderAdapterExample(getContext());
        sliderView2.setSliderAdapter(adapter2);
        sliderView2.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView2.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView2.setAutoCycleDirection(sliderView2.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView2.setIndicatorSelectedColor(Color.WHITE);
        sliderView2.setIndicatorUnselectedColor(Color.GRAY);
        sliderView2.setScrollTimeInSec(4);
        sliderView2.setAutoCycle(true);
        sliderView2.startAutoCycle();


        List<SliderItem> sliderItemList = new ArrayList<>();
//        dummy data
        ArrayList<String> URL = new ArrayList<>();
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/1.png?alt=media&token=1eda3b11-3135-4c5a-af7b-a858f1477c2e");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/2.png?alt=media&token=8fd54f11-b8bd-4d8a-850f-6501f9c4e210");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/3.png?alt=media&token=1b8ac351-9c2a-4182-aa06-8878b3a2945c");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/4.png?alt=media&token=460a43fc-3c53-4f09-b759-093e780afde9");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/5.png?alt=media&token=5cb74d32-3795-4336-8a7b-5aafd9a543eb");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/6.png?alt=media&token=8dc2afac-14ed-4cea-83a3-5a36696584d4");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/7.png?alt=media&token=d580f174-d87e-43a3-9112-43c1de3be751");
        URL.add("https://firebasestorage.googleapis.com/v0/b/fir-demoapp-9413d.appspot.com/o/8.png?alt=media&token=1fc6e177-24a1-45df-896b-dec2460f353b");

        for (int i = 0; i < URL.size(); i++) {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescription("News Item " + (i+1));
            sliderItem.setImageUrl(URL.get(i));
            sliderItemList.add(sliderItem);
        }
        adapter2.renewItems(sliderItemList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_news, container, false);

    }
}