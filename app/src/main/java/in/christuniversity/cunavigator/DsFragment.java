package in.christuniversity.cunavigator;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DsFragment extends Fragment {

    private FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDB.getReference();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    ArrayList<TimeTableData> data = new ArrayList<>();
    RecyclerView recyclerView ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void loadUI(){

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView =  getView().findViewById(R.id.ds_timtable);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRef.child("Teachers").child(mAuth.getUid()).child("schedule").child("regular").child("monday").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String,HashMap<String, String>> td = (HashMap<String,HashMap<String, String>>)snapshot.getValue();
                if(td!=null) {
                    int i =0;
                    ArrayList<String> sortedKeys = new ArrayList<>(td.keySet());
                    Collections.sort(sortedKeys);
                    for (String keys : sortedKeys) {
                        i++;
                        Log.v("Keys", keys);
                        HashMap<String,String> value =  (HashMap<String,String>) td.get(keys);
                        Log.v(value.toString(),value.keySet().toString());
                        data.add(new TimeTableData(value.get("Subject"),keys,value.get("SubjectCode"),value.get("Block"),("P"+i)));
                    }
                    recyclerView.setAdapter(new TimeTableAdapter(data,getContext()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        data.add(new TimeTableData("Python Programming","09:00 - 10:00","BCA543","06(Block III)","P0"));
//        data.add(new TimeTableData("Java Programming","10:00 - 11:00","BCA521","06(Block III)","P1"));
//        data.add(new TimeTableData("Python Programming","11:00 - 12:00","BCA543","06(Block III)","P2"));
//        data.add(new TimeTableData("Java Programming","12:00 - 13:00","BCA521","06(Block III)","P3"));
//        data.add(new TimeTableData("Python Programming","14:00 - 16:00","BCA543","06(Block III)","P4"));
//        data.add(new TimeTableData("Teacher Training","17:00 - 18:00","TTP","(Block II)","M0"));
//        data.add(new TimeTableData("Python Programming","09:00 - 10:00","BCA543","06(Block III)","P0"));
//        data.add(new TimeTableData("Java Programming","10:00 - 11:00","BCA521","06(Block III)","P1"));
//        data.add(new TimeTableData("Python Programming","11:00 - 12:00","BCA543","06(Block III)","P2"));
//        data.add(new TimeTableData("Java Programming","12:00 - 13:00","BCA521","06(Block III)","P3"));
//        data.add(new TimeTableData("Python Programming","14:00 - 16:00","BCA543","06(Block III)","P4"));
//        data.add(new TimeTableData("Teacher Training","17:00 - 18:00","TTP","(Block II)","M0"));

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ds, container, false);
    }
}