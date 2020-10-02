package in.christuniversity.cunavigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Pattern;

public class StudentLogin extends AppCompatActivity implements View.OnClickListener {

     FirebaseAuth mAuth;
     FirebaseUser mCurrentUser;
    private TextInputEditText stuEmail, stuPassword;
   private ProgressBar login_progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        stuEmail = findViewById(R.id.edit_email);
        stuPassword = findViewById(R.id.edit_password);
        login_progress_bar = findViewById(R.id.login_progress_bar);

        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        findViewById(R.id.login).setOnClickListener(this);


    }

    private void userLogin() {

        String email = stuEmail.getText().toString().trim();
        String password = stuPassword.getText().toString().trim();
        login_progress_bar.setVisibility(View.VISIBLE);

        if(email.isEmpty()){
            stuEmail.setError("Email is Required");
            stuPassword.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            stuEmail.setError("Enter a valid email");
            stuPassword.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            stuEmail.setError("Password is Required");
            stuPassword.requestFocus();
            return;
        }

        if(password.length() < 8) {
            stuEmail.setError("Min length of password is 8");
            stuPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent dashboard = new Intent(StudentLogin.this, StudentDashboard.class);
                    dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(dashboard);
                    finish();

                }
                else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
         userLogin();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}