package com.mfachriadrianta.latihan02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class SigninAct extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;

    EditText edtemailaddress, edtpassword;
    View progress_Bar_Signin;
    TextView txtnewaccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edtemailaddress = findViewById(R.id.edt_edit_email_address);
        edtpassword = findViewById(R.id.edt_edit_password);
        progress_Bar_Signin = findViewById(R.id.progressbarsignin);
        txtnewaccount = findViewById(R.id.txt_new_account);

        progress_Bar_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
