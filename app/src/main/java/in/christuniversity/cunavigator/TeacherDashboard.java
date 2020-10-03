package in.christuniversity.cunavigator;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class TeacherDashboard extends AppCompatActivity {

    HomeFragment hf;
    ScheduleFragment sf;
    SearchFragment srcf;
    NewsFragment nf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);
//        RecyclerView programminglist = findViewById(R.id.programminglist);
//        programminglist.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        String[] languages  = {"Java","JavaScript","C#","php","C","C++","Python","Java","JavaScript","C#","php","C","C++","Python"};
//        programminglist.setAdapter(new ProgammingAdapter(languages,this));
        hf = new HomeFragment();
        sf = new ScheduleFragment();
        srcf = new SearchFragment();
        nf = new NewsFragment();
        setFragment(hf);
        BottomNavigationView BNV = findViewById(R.id.teacher_nav);
        BNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.teacher_home: {
                        setFragment(hf);
                        return true;
                    }
                    case R.id.teacher_schedule: {
                        setFragment(sf);
                        return true;
                    }
                    case R.id.teacher_search: {
                        setFragment(srcf);
                        return true;
                    }
                    case R.id.teacher_news:{
                        setFragment(nf);
                        return true;
                    }

                }
                return false;
            }
        });
    }

    private void setFragment(Fragment hf) {
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame,hf);
        ft.commit();

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton(Html.fromHtml("<font color='#FF7F27'>Yes</font>"), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        FirebaseAuth.getInstance().signOut();
                        finish();
                    }
                })
                .setNegativeButton(Html.fromHtml("<font color='#FF7F27'>No</font>"), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                    }

                })
                .show();
    }
}