package com.example.ascourse1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText lastname;
    EditText email;
    EditText pass;
    Button button;
    TextView nametext;
    TextView lastnametext;
    TextView emailtext;
    TextView passtext;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        button = findViewById(R.id.button1);
        nametext = findViewById(R.id.nametext);
        lastnametext = findViewById(R.id.lastnametext);
        emailtext = findViewById(R.id.emailtext);
        passtext = findViewById(R.id.passtext);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nametext.setText("First name: " + name.getText().toString());
                lastnametext.setText("Last Name:" + lastname.getText().toString());
                emailtext.setText("Email adress: " + email.getText().toString());
                passtext.setText("Password: " + pass.getText().toString());

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                lastname.setText("");
                email.setText("");
                pass.setText("");

                nametext.setText("First name: " + "");
                lastnametext.setText("Last Name: " + "");
                emailtext.setText("Email adress: " + "");
                passtext.setText("Password: " + "");
            }
        });



    }




}