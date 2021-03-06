package com.mattar.areen.firebaseex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    FirebaseAuth firebaseAuth;

    Button btnReg,btnLogin;
    EditText etEmail,etPass;
     int mode=0; // o means register 1 means login



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnReg = (Button)findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(this);

            }



    @Override
    public void onClick(View v) {

        if (v==btnReg)
        {   Toast.makeText(MainActivity.this, "Successfully registered", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(MainActivity.this,Reg.class);
            startActivity(intent);
        }
        if (v==btnLogin)
        {
            Intent intent=new Intent(MainActivity.this,LoginPage.class);
            startActivity(intent);
        }


    }
}
