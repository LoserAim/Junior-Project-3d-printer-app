package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class activity_submit_request extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_request);

        EditText userName = findViewById(R.id.editName);
        userName.addTextChangedListener(new TextValidator(userName) {
            @Override public void validate(TextView textView, String text) {
                if (!text.matches("[ a-zA-Z]+$"))
                {
                    textView.setError("Please only enter your name.");
                }
            }
        });

        EditText userFilepath = findViewById(R.id.editFilepath);

        TextView userDate = findViewById(R.id.textDate);

        EditText userDescription = findViewById(R.id.editDescription);
        userDescription.addTextChangedListener(new TextValidator(userDescription) {
            @Override public void validate(TextView textView, String text) {
                if (text.length() < 5)
                {
                    textView.setError("Please provide a description of your project.");
                }
            }
        });

        Spinner spinnerPrinters = findViewById(R.id.spinnerPrinters);
        spinnerPrinters.setOnItemSelectedListener(new SpinnerActivity());
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
        Intent intent = new Intent(this, activity_home.class);
        startActivity(intent);
        // Notify user that request is sent
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            // parent.getItemAtPosition(pos)
            Toast.makeText(parent.getContext(), parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    //Source: https://stackoverflow.com/questions/33072569/best-practice-input-validation-android
    public abstract class TextValidator implements TextWatcher {
        private final TextView textView;

        public TextValidator(TextView textView) {
            this.textView = textView;
        }

        public abstract void validate(TextView textView, String text);

        @Override
        final public void afterTextChanged(Editable s) {
            String text = textView.getText().toString();
            validate(textView, text);
        }

        @Override
        final public void
        beforeTextChanged(CharSequence s, int start, int count, int after) {
            /* Needs to be implemented, but we are not using it. */
        }

        @Override
        final public void
        onTextChanged(CharSequence s, int start, int before, int count) {
            /* Needs to be implemented, but we are not using it. */
        }
    }
}
