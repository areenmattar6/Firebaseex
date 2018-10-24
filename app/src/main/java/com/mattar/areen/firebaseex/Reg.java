package com.mattar.areen.firebaseex;

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

public class Reg extends AppCompatActivity implements View.OnClickListener {


    FirebaseAuth firebaseAuth;

    Button btnReg;
    EditText etEmail,etPass;
    int mode=0; // o means register 1 means login



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        btnReg = (Button)findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(this);

    }

    public void register()
    {

        firebaseAuth.createUserWithEmailAndPassword(etEmail.getText().toString(),etPass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Reg.this, "Successfully registered", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(Reg.this, "Registration Error", Toast.LENGTH_LONG).show();

                }

            }
        });

    }


    @Override
    public void onClick(View v) {

        if (btnReg==v)
        {
            register();
        }


    }
}
