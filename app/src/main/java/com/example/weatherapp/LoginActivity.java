package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class LoginActivity extends AppCompatActivity {
    EditText user_email , user_pass;
    Button btnLogin;
    TextView ClickRegister;
    DBHelper myDB;


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitivity);
        user_email = (EditText)findViewById(R.id.editTextEmail);
        user_pass = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        ClickRegister = (TextView) findViewById(R.id.textViewRegister);
        myDB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = user_email.getText().toString();
                String passs = user_pass.getText().toString();

                if (user_email.equals("") || user_pass.equals("")){
                    Toast.makeText(LoginActivity.this,"Please Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean result = myDB.checkemailpassword(user,passs);
                    if (result == true){
                        Intent intent =new Intent(getApplicationContext(),WeatherActivity.class);
                        startActivity(intent);
                    }
                else {
                    Toast.makeText(LoginActivity.this,"Invalid Crediantials.",Toast.LENGTH_SHORT).show();


                    }

                }

            }
        });
        ClickRegister.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}