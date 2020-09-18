package in.christuniversity.cunavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Selection extends AppCompatActivity {

Button student, teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        student = findViewById(R.id.students);
        teacher = findViewById(R.id.teachers);


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent stulogin = new Intent(Selection.this,StudentLogin.class);
                startActivity(stulogin);

            }
        });

        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacher = new Intent(Selection.this,TeacherLogin.class);
                startActivity(teacher);
            }
        });

    }



}