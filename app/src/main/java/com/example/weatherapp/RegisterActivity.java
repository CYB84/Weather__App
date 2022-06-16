package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,email,psw;
    Button btnRegister;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmailAdd);
        psw = (EditText)findViewById(R.id.editTextPassword2);

        btnRegister =(Button)findViewById(R.id.btnRegister);
        myDB = new DBHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String ema = email.getText().toString();
                String pass = psw.getText().toString();
                Boolean checkInsertData = myDB.insertData(user,pass,ema);

                if (ema.equals("") || pass.equals("")){
                    Toast.makeText(RegisterActivity.this,"Fill All The Fields.",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(checkInsertData==true){
                        Toast.makeText(RegisterActivity.this, "Data inserted successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),WeatherActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Data cannot be inserted!!", Toast.LENGTH_SHORT).show();
                    }
                        }

                    }




        });



    }
}