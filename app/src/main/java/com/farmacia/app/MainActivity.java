package com.farmacia.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    TextInputEditText etEmail;
    TextInputEditText etPassword;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void initViews() {
        mAuth = FirebaseAuth.getInstance();
        etEmail = (TextInputEditText) findViewById(R.id.et_email_login);
        etEmail = (TextInputEditText) findViewById(R.id.et_password_login);

    }

    public void clickAcceder(View view) {
        //  if (TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText())){
        //     Toast.makeText( this,"Debes rellenar todos los campos ", Toast.LENGTH_SHORT).show();
        //    }else {
      //  String email = etEmail.getText().toString();
        //String password = etPassword.getText().toString();
        Intent intentScreen = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(intentScreen);
    //    acceder(email, password);

    }


//}
    private void acceder(String email, String  password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener( this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText( getApplicationContext(),"Accediste con exito", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText( getApplicationContext(),"No se ha podido acceder  ", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }



    public void clickRecuperarPass(View view){

        String email = etEmail.getText().toString();

        if(TextUtils.isEmpty(etEmail.getText())) {
            Toast.makeText( getApplicationContext(),"introduce un email", Toast.LENGTH_SHORT).show();

        }else {
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText( getApplicationContext(),"Se le ah enviado un email para reestablecer su contraseña ", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }
                }


