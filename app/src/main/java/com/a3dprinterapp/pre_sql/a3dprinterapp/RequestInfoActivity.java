package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RequestInfoActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestinfo);
        EditText userName = findViewById(R.id.editName);
        EditText userFilepath = findViewById(R.id.editFilepath);
        TextView userDate = findViewById(R.id.textDate);
        EditText userDescription = findViewById(R.id.editDescription);
    }

    public void AddAttachment(View view)
    {
        // Have user choose file to attach
    }

    public void ChangeDate(View view)
    {
        // Have user be able to change the date of scheduled print
    }

    public void SubmitRequest(View view)
    {
        // Submit the print request
    }
}
