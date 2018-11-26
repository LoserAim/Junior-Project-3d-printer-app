package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
//This activity will allow the admin to see the users request, as well as, being able to
//send a message to the user, and/or moving the users request to the approved, denied, or requested
//activity by using the drop down menu to select the activity and then pressing the submit button
//to finalize the change.
public class AdminResponse extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_response);

        //Once you click the submit button you will go back to the admin page
        button = findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openAdminHome();
            }
        });

        //Sets up the spinner
        Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.RequestMover, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    //Moves to the admin page
    public void openAdminHome(){
        Intent intent = new Intent(this, MainAdminActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Edit to have a users request sent to the rejected, approved, or request activities
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
