package com.mfachriadrianta.latihan02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.database.DatabaseReference;

public class SplashAct extends AppCompatActivity {

    private AuthStateListener authStateListener;
    private DatabaseReference reference;

    private Animation animation;
    ImageView applogo;
    TextView apptitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        applogo = findViewById(R.id.app_logo);
        apptitle = findViewById(R.id.app_title);

        animation = AnimationUtils.loadAnimation(this,R.anim.logo);

        applogo.startAnimation(animation);
        apptitle.startAnimation(animation);
        checkConnection();
    }

    public void checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED
            || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashAct.this, SigninAct.class);
                    startActivity(intent);
                }
            }, 3000);
        } else {
            Toast.makeText(this,"Nothing connection internet!", Toast.LENGTH_SHORT).show();
            return;
        }
    }
}
