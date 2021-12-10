package com.example.registerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;

public class registerActivity extends AppCompatActivity {

    TextInputLayout name_input,lastname_input,email_input,password_input;
    EditText name_input1,lastname_input1,email_input1,password_input1;
    Button signupBtn;
    TextView txtbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signupBtn = findViewById(R.id.signupBtn);
        name_input1 = findViewById(R.id.name_input1);
        lastname_input1 = findViewById(R.id.lastname_input1);
        email_input1 = findViewById(R.id.email_input1);
        password_input1 = findViewById(R.id.password_input1);
        name_input = findViewById(R.id.name_input);
        lastname_input = findViewById(R.id.lastname_input);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        txtbtn = findViewById(R.id.txtbtn);







        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLite myDB = new SQLite(registerActivity.this);

                if (name_input1.length()!=0&&lastname_input1.length()!=0&&email_input1.length()!=0&&password_input1.length()!=0){
                    myDB.register(name_input1.getText().toString().trim(),
                            lastname_input1.getText().toString().trim(),
                            email_input1.getText().toString().trim(),
                            password_input1.getText().toString().trim());
                }




                if (name_input1.length()==0){
                    name_input.setError("Enter your Name");
                }else {
                    name_input.setError(null);
                }
                if (lastname_input1.length()==0){
                    lastname_input.setError("Enter your Last Name");
                }else {
                    lastname_input.setError(null);
                }
                if (email_input1.length()==0){
                    email_input.setError("Enter your Email");
                }else {
                    email_input.setError(null);
                }
                if (password_input1.length()==0){
                    password_input.setError("Enter your Password");
                }else {
                    password_input.setError(null);
                }


            }
        });


        txtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getBaseContext(),loginActivity.class);
                startActivity(login);

            }
        });




    }




}