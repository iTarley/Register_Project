package com.example.ascourse1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText lastname;
    EditText email;
    EditText pass;
    Button button,next_page;
    TextView nametext;
    TextView lastnametext;
    TextView emailtext;
    TextView passtext;
    Button button2;
    boolean isRegistred = false;




    @SuppressLint("SetTextI18n")
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
        next_page = findViewById(R.id.next_page);


        // register button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLite myDB = new SQLite(MainActivity.this);
                myDB.register(name.getText().toString().trim(),
                        lastname.getText().toString().trim(),
                        email.getText().toString().trim(),
                        pass.getText().toString().trim());



                nametext.setText("First name: " + name.getText().toString());
                lastnametext.setText("Last Name: " + lastname.getText().toString());
                emailtext.setText("Email adress: " + email.getText().toString());
                passtext.setText("Password: " + pass.getText().toString());
                isRegistred = true;



            }
        });
        // reset button
        button2.setOnClickListener(v -> {

            SQLite myDB = new SQLite(MainActivity.this);
            myDB.deleteAll();




            name.setText("");
            lastname.setText("");
            email.setText("");
            pass.setText("");

            nametext.setText("First name: " + "");
            lastnametext.setText("Last Name: " + "");
            emailtext.setText("Email adress: " + "");
            passtext.setText("Password: " + "");
            Toast.makeText(getBaseContext(),"Reset",Toast.LENGTH_SHORT).show();
            isRegistred = false;
        });


        next_page.setOnClickListener(v -> {
            if (isRegistred){
                Intent login = new Intent(getBaseContext(),LoginPage.class);
                startActivity(login);


            }


        });



    }




}