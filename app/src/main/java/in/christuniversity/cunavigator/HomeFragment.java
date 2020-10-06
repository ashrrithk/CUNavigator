package in.christuniversity.cunavigator;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import in.christuniversity.cunavigator.Model.SliderItem;


public class HomeFragment extends Fragment {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseDatabase mDb = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDb.getReference();
    private ProgressDialog pd;
    ArrayList<StudentMeet> data = new ArrayList<>();
    int f =0;
    ImageView DP;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void updateUI(final View view){

        DP = getView().findViewById(R.id.teacherDp);
        final TextView Teacher_Welcome = getView().findViewById(R.id.teacher_welcome);
        final TextView Teacher_Name = getView().findViewById(R.id.teacher_name);
        final TextView Teacher_Designation = getView().findViewById(R.id.teacher_designation);
        final TextView Teacher_Dept = getView().findViewById(R.id.teacher_department);
        final LinearLayout FragmentHome = getView().findViewById(R.id.fragment_home);
        mRef.child("Teachers").child(mAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String,String> td = (HashMap<String,String>)snapshot.getValue();
                if(td!=null){
                    for(String keys:td.keySet()){
                        Log.i("Keys",keys);}
                        Glide.with(DP.getContext()).load(td.get("image")).into(DP);
                        Teacher_Welcome.setText("Welcome");
                        Teacher_Name.setText(td.get("Name"));
                        Teacher_Designation.setText(td.get("designation"));
                        Teacher_Dept.setText(td.get("Department"));
                        try{

                                FragmentHome.setAlpha((float) 1);



                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                        pd.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });



        //Recycler View for meeting
        final RecyclerView programminglist = (RecyclerView) getView().findViewById(R.id.StudentList);
        programminglist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        mRef.child("Teachers").child(mAuth.getUid()).child("schedule").child("regular").child("meet").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                HashMap<String, HashMap<String, String>> td = (HashMap<String, HashMap<String, String>>) snapshot.getValue();
                if (td != null) {
                    int i = 0;
                    ArrayList<String> sortedKeys = new ArrayList<>(td.keySet());
                    Collections.sort(sortedKeys);
                    for (String keys : sortedKeys) {
                        i++;
                        Log.v("Keys", keys);
                        HashMap<String, String> value = (HashMap<String, String>) td.get(keys);
                        Log.v(value.toString(), value.keySet().toString());
                        data.add(new StudentMeet(value.get("Student"), value.get("Class"),keys));
                        programminglist.setAdapter(new ProgammingAdapter(data,getContext()));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateUI(view);
        pd = ProgressDialog.show(getContext(),"Loading Data","Please Wait");
        getView().findViewById(R.id.fragment_home).setAlpha((float)0.5);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}