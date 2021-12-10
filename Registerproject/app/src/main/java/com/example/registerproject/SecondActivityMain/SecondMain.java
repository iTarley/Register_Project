package com.example.registerproject.SecondActivityMain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.registerproject.R;
import com.example.registerproject.SQLite;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondMain extends AppCompatActivity {


    TextView usertxtinfo1,usertxtinfo2;
    SQLite db;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        usertxtinfo1 =findViewById(R.id.usertxtinfo1);
        usertxtinfo2 = findViewById(R.id.usertxtinfo2);
        db = new SQLite(this);





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,  R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);










    }
}