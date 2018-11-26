package com.a3dprinterapp.pre_sql.a3dprinterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_register extends AppCompatActivity {

    DB_DatabaseHelper db;
    MD_Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db      = new DB_DatabaseHelper(getApplicationContext());
        student = new MD_Student();


        // Validation for student first name
        EditText studentFirstNameEditText =((EditText)findViewById(R.id.editText5));

        studentFirstNameEditText.addTextChangedListener(new TextValidator(studentFirstNameEditText) {
            @Override public void validate(TextView textView, String text) {
                if (!text.matches("[ a-zA-Z]+$"))
                {
                    textView.setError("Please only enter your first name");
                }
            }
        });


        // Validation for student email
        EditText studentEmailEditText = findViewById(R.id.editText6);

        studentEmailEditText.addTextChangedListener(new TextValidator(studentEmailEditText) {
            @Override public void validate(TextView textView, String text) {
                // Source: https://stackoverflow.com/a/15808057
                if (!(!TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()))
                {
                    textView.setError("Please enter a valid email");
                }
            }
        });


        // Validation for confirm password
        EditText confirmPasswordEditText = findViewById(R.id.editText4);

        confirmPasswordEditText.addTextChangedListener(new TextValidator(confirmPasswordEditText) {
            @Override public void validate(TextView textView, String text) {
                if(text.compareTo(((EditText)findViewById(R.id.editText3)).getText().toString()) != 0)
                {
                    textView.setError("Passwords do not match");
                }
            }
        });
    }

    public void registerNewStudent (){
        String studentEmail    = ((EditText)findViewById(R.id.editText6)).getText().toString();
        String studentName     = ((EditText)findViewById(R.id.editText5)).getText().toString();
        String password        = ((EditText)findViewById(R.id.editText3)).getText().toString();

        student.SetEmail(studentEmail);
        student.SetName(studentName);
        student.SetPassword(password);

        db.CreateStudent(student);
    }

    public void goToHomeActivity (View view){
        registerNewStudent();
        Intent intent = new Intent (this, activity_home.class);
        startActivity(intent);
    }


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
