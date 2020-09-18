package in.christuniversity.cunavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudentLogin extends AppCompatActivity {

    public void login(View view){
        Intent i = new Intent(StudentLogin.this, StudentDashboard.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
    }
}