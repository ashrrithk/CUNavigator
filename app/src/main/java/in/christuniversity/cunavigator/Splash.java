package in.christuniversity.cunavigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {
    FirebaseAuth.AuthStateListener mAuthListener;

    private static int SPLASH_SCREEN = 2000;
    //Variables
Animation topAnim, bottomAnim;
TextView main, sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_navigation);

        //Hooks
        main = findViewById(R.id.main_text_splash);
        sub = findViewById(R.id.sub_text_splash);

        main.setAnimation(topAnim);
        sub.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent selection = new Intent(Splash.this,Selection.class);
                        startActivity(selection);
                        finish();
            }
        },SPLASH_SCREEN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public  void  onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user!=null){
                    Intent intent = new Intent(Splash.this, StudentDashboard.class);
                    startActivity(intent);
                    finish();
                }
            }


        };
    }
}