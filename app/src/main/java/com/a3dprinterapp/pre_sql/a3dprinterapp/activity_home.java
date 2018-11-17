package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activity_home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void StartPrintRequest(View view)
    {
        // move to print request info page
        Intent intent = new Intent(this, RequestInfoActivity.class);
        startActivity(intent);
    }
}
