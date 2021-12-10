package com.example.registerproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.registerproject.SecondActivityMain.SecondMain;
import com.google.android.material.textfield.TextInputLayout;

public class loginActivity extends AppCompatActivity {

    EditText email_login1, password_login1;
    Button loginBtn,guest;
    TextInputLayout email_login, password_login;
    SQLite db;
    TextView txtbtn2;
    TextView usertxtinfo1,usertxtinfo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.loginBtn);
        email_login = findViewById(R.id.email_login);
        email_login1 = findViewById(R.id.email_login1);
        password_login = findViewById(R.id.password_login);
        password_login1 = findViewById(R.id.password_login1);
        db = new SQLite(this);
        txtbtn2 = findViewById(R.id.txtbtn2);
        guest = findViewById(R.id.guest);




        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = email_login1.getText().toString();
                String pass = password_login1.getText().toString();


                Boolean checkemailandpassword = db.checkemailandpassword(mail,pass);
                Boolean checkmail = db.checkmail(mail);
                Boolean checkpass = db.checkpass(pass);


                if (checkemailandpassword){
                    Intent second = new Intent(getBaseContext(),SecondMain.class);
                    startActivity(second);



                }
                if (!checkmail){
                    email_login.setError("This email does not exist");

                }else {
                    email_login.setError(null);
                }
                if (!checkpass){
                    password_login.setError("Email and Password do not match");
                }else {
                    password_login.setError(null);
                }


            }
        });

        txtbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getBaseContext(),registerActivity.class);
                startActivity(login);
            }
        });


        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent second = new Intent(getBaseContext(), SecondMain.class);
                startActivity(second);

            }
        });

    }

}