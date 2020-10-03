package in.christuniversity.cunavigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TeacherLogin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextInputEditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        username = findViewById(R.id.Teacher_email);
        password = findViewById(R.id.Teacher_password);
        mAuth = FirebaseAuth.getInstance();
    }
    public void login(View view){
        String email,pass;
        email = username.getText().toString();
        pass = password.getText().toString();
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    userlogin(mAuth.getCurrentUser());
                }
                else {
                    Toast.makeText(TeacherLogin.this,"Failed to Login Please Check the information entered and Try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        userlogin(mAuth.getCurrentUser());
    }

    public void userlogin(FirebaseUser user){
        if(user != null){
            Intent i = new Intent(TeacherLogin.this,TeacherDashboard.class);
            i.putExtra("UID",user.getUid());
            i.putExtra("Email",user.getEmail());
            startActivity(i);
        }
    }
}