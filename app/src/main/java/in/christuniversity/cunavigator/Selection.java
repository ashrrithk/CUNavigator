package in.christuniversity.cunavigator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
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

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();
    }



}