package in.christuniversity.cunavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TeacherLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
    }
    public void login(View view){
        Intent i = new Intent(this,TeacherDashboard.class);
        startActivity(i);
    }
}