package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class activity_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void goToHomeActivity (View view){
        Intent intent = new Intent (this, activity_home.class);
        startActivity(intent);
    }
}
